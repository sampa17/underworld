package net.mcreator.project.procedures;

import net.minecraft.world.World;
import net.minecraft.world.Explosion;

import net.mcreator.project.ProjectModElements;

@ProjectModElements.ModElement.Tag
public class BombonneBlockDestroyedByPlayerProcedure extends ProjectModElements.ModElement {
	public BombonneBlockDestroyedByPlayerProcedure(ProjectModElements instance) {
		super(instance, 21);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BombonneBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BombonneBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BombonneBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BombonneBlockDestroyedByPlayer!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.createExplosion(null, (int) x, (int) y, (int) z, (float) 20, Explosion.Mode.BREAK);
		}
	}
}
