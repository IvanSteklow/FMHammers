package ivansteklow.fmhammers.tools;

import ivansteklow.fmhammers.init.Refs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemHammer extends ItemPickaxe {

	public ItemHammer() {
		super(ToolMaterial.IRON);
		this.setUnlocalizedName("hammer");
		this.setRegistryName(new ResourceLocation(Refs.MOD_ID, "hammer"));
	}

	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
		World world = player.getEntityWorld();
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		int breakRadius = 1;
		int breakDepth = 0;
		int xRange = breakRadius;
        int yRange = breakRadius;
        int zRange = breakDepth;
		Vec3d vec3d = player.getPositionVector();
		RayTraceResult raytrace = new RayTraceResult(player, vec3d);
		switch (raytrace.sideHit) {
	        case UP:
	            yRange = breakDepth;
	            zRange = breakRadius;
	            break;
	        case SOUTH:
	            xRange = breakRadius;
	            zRange = breakDepth;
	            break;
	        case EAST:
	            xRange = breakDepth;
	            zRange = breakRadius;
	            break;
	        default:
	        	break;
		}
		if (!world.isRemote) {
			world.destroyBlock(pos, true);
			for (int xPos = x - xRange; xPos <= x + xRange; xPos++)
                for (int yPos = y - yRange; yPos <= y + yRange; yPos++)
                    for (int zPos = z - zRange; zPos <= z + zRange; zPos++) {
                        // don't break the originally already broken block, duh
                        if (xPos == x && yPos == y && zPos == z)
                            continue;
                        if (!super.onBlockStartBreak(itemstack, new BlockPos(xPos, yPos, zPos), player))
                            world.destroyBlock(new BlockPos(xPos, yPos, zPos), true);
                    }
		}
		return super.onBlockStartBreak(itemstack, pos, player);
	}

}
