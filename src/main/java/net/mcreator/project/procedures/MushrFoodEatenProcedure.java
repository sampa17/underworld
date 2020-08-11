package net.mcreator.project.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.project.ProjectModElements;

import java.util.Map;

@ProjectModElements.ModElement.Tag
public class MushrFoodEatenProcedure extends ProjectModElements.ModElement {
	public MushrFoodEatenProcedure(ProjectModElements instance) {
		super(instance, 73);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MushrFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 40, (int) 1));
	}
}
