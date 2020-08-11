package net.mcreator.project.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.project.item.BedrocktracerItem;
import net.mcreator.project.block.SurfacestoneBlock;
import net.mcreator.project.ProjectModElements;

import java.util.Map;
import java.util.HashMap;

@ProjectModElements.ModElement.Tag
public class SwitchdimProcedure extends ProjectModElements.ModElement {
	public SwitchdimProcedure(ProjectModElements instance) {
		super(instance, 8);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Switchdim!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Switchdim!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Switchdim!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Switchdim!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Switchdim!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SurfacestoneBlock.block.getDefaultState().getBlock())
				&& ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("project:bedrockbiome")))
						&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
								.getItem() == new ItemStack(BedrocktracerItem.block, (int) (1)).getItem())))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
					DimensionType destinationType = DimensionType.OVERWORLD;
					ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
					ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
					((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
							nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
					for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
					}
					((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
				}
			}
		}
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
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
