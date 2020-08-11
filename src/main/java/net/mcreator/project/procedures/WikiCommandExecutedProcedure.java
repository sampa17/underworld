package net.mcreator.project.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.project.ProjectModElements;

import java.util.Map;

@ProjectModElements.ModElement.Tag
public class WikiCommandExecutedProcedure extends ProjectModElements.ModElement {
	public WikiCommandExecutedProcedure(ProjectModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WikiCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("https://github.com/sampa17/underworld/wiki/Page-1"), (false));
		}
	}
}
