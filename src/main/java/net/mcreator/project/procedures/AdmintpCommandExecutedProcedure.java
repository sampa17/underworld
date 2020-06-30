package net.mcreator.project.procedures;

@ProjectModElements.ModElement.Tag
public class AdmintpCommandExecutedProcedure extends ProjectModElements.ModElement {

	public AdmintpCommandExecutedProcedure(ProjectModElements instance) {
		super(instance, 45);

	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AdmintpCommandExecuted!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).setGameType(GameType.CREATIVE);

	}

}
