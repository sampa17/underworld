package net.mcreator.project.procedures;

@ProjectModElements.ModElement.Tag
public class UnderwaterMobplayerCollidesBlockProcedure extends ProjectModElements.ModElement {

	public UnderwaterMobplayerCollidesBlockProcedure(ProjectModElements instance) {
		super(instance, 44);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UnderwaterMobplayerCollidesBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 1, (int) 2));

	}

}
