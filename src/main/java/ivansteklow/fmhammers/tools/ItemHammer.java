package ivansteklow.fmhammers.tools;

import ivansteklow.fmhammers.init.Refs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemHammer extends ItemPickaxe {

	int breakRadius = 1;
	int breakDepth = 0;
	String matName = "wooden";

	public ItemHammer(ToolMaterial material, int radius, int depth) {
		super(material);
		this.breakRadius = radius;
		this.breakDepth = depth;
		
		if(material == Refs.STARMETAL){
			this.matName = "starmetal";
		}else if(material == ToolMaterial.WOOD){
			this.matName = "wooden";
		}else if(material == ToolMaterial.STONE){
			this.matName = "stone";
		}else if(material == ToolMaterial.IRON){
			this.matName = "iron";
		}else if(material == ToolMaterial.GOLD){
			this.matName = "golden";
		}else if(material == ToolMaterial.DIAMOND){
			this.matName = "diamond";
		}
		this.setUnlocalizedName(this.matName + "_hammer");
		this.setRegistryName(new ResourceLocation(Refs.MOD_ID, this.matName + "_hammer"));
		this.setHarvestLevel("pickaxe", material.getHarvestLevel());
		this.setMaxDamage(material.getMaxUses() + 500);
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
		if (!player.isSneaking()) {
			World world = player.getEntityWorld();
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			int xRange = breakRadius;
			int yRange = breakRadius;
			int zRange = breakDepth;
			switch (this.rayTrace(world, player, false).sideHit) {
			case DOWN:
			case UP:
				yRange = breakDepth;
				zRange = breakRadius;
				break;
			case NORTH:
			case SOUTH:
				xRange = breakRadius;
				zRange = breakDepth;
				break;
			case WEST:
			case EAST:
				xRange = breakDepth;
				zRange = breakRadius;
				break;
			}
			if (!world.isRemote) {
				if (world.getBlockState(pos).getBlock().canHarvestBlock(world, pos, player) && !(world.getBlockState(pos).getBlock() == Blocks.BEDROCK || world.getBlockState(pos).getBlock() == Blocks.BARRIER))
					if (player.isCreative()) {
						world.destroyBlock(pos, false);
					} else {
						world.destroyBlock(pos, true);
					}
				for (int xPos = x - xRange; xPos <= x + xRange; xPos++)
					for (int yPos = y - yRange; yPos <= y + yRange; yPos++)
						for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
							if (xPos == x && yPos == y && zPos == z)
								continue;
							if (!super.onBlockStartBreak(itemstack, new BlockPos(xPos, yPos, zPos), player)) {
								if (world.getBlockState(new BlockPos(xPos, yPos, zPos)).getBlock()
										.canHarvestBlock(world, new BlockPos(xPos, yPos, zPos), player)
										&& isEffective(world.getBlockState(new BlockPos(xPos, yPos, zPos)))) {
									if (player.isCreative()) {
										world.destroyBlock(new BlockPos(xPos, yPos, zPos), false);
									} else {
										world.destroyBlock(new BlockPos(xPos, yPos, zPos), true);
										itemstack.damageItem(1, player);
									}
								}
							}
						}
			}
		} else {
			return super.onBlockStartBreak(itemstack, pos, player);
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	public boolean isEffective(IBlockState state) {
		Block block = state.getBlock();
		Material material = block.getMaterial(state);
		if (material == null)
			return true;
		for (Material m : getEffectiveMaterials())
			if (m == material)
				return true;

		return false;
	}

	protected Material[] getEffectiveMaterials() {
		return materials;
	}

	public static Material[] materials = new Material[] { Material.ROCK, Material.IRON, Material.ICE, Material.GLASS,
			Material.PISTON, Material.ANVIL };

}
