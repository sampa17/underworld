
package net.mcreator.project.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.project.item.VibranimItem;
import net.mcreator.project.ProjectModElements;

@ProjectModElements.ModElement.Tag
public class VibraniumfuelFuel extends ProjectModElements.ModElement {
	public VibraniumfuelFuel(ProjectModElements instance) {
		super(instance, 14);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(VibranimItem.block, (int) (1)).getItem())
			event.setBurnTime(3000);
	}
}
