package net.mcreator.project.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.project.item.TitanehammerItem;
import net.mcreator.project.ProjectModElements;

import java.util.Map;
import java.util.HashMap;

@ProjectModElements.ModElement.Tag
public class TitanehammerproProcedure extends ProjectModElements.ModElement {
	public TitanehammerproProcedure(ProjectModElements instance) {
		super(instance, 38);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Titanehammerpro!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Titanehammerpro!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Titanehammerpro!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Titanehammerpro!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Titanehammerpro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.BEDROCK.getDefaultState().getBlock())
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(TitanehammerItem.block, (int) (1)).getItem()))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage((int) 2);
		}
	}

	@SubscribeEvent
	public void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand())
			return;
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
		World world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
