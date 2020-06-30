package net.mcreator.project.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.project.ProjectModElements;

@ProjectModElements.ModElement.Tag
public class Caracornmeat1FoodEatenProcedure extends ProjectModElements.ModElement {
	public Caracornmeat1FoodEatenProcedure(ProjectModElements instance) {
		super(instance, 58);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Caracornmeat1FoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 5, (int) 2));
	}
}
