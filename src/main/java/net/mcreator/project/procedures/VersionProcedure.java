package net.mcreator.project.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.project.ProjectModElements;

import java.util.Map;
import java.util.HashMap;

@ProjectModElements.ModElement.Tag
public class VersionProcedure extends ProjectModElements.ModElement {
	public VersionProcedure(ProjectModElements instance) {
		super(instance, 13);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Version!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Underworld Version : V 1.2"), (false));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
