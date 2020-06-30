
package net.mcreator.project.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.project.itemgroup.TabmodItemGroup;
import net.mcreator.project.ProjectModElements;

@ProjectModElements.ModElement.Tag
public class CaracornMeat2Item extends ProjectModElements.ModElement {
	@ObjectHolder("project:caracorn_meat_2")
	public static final Item block = null;
	public CaracornMeat2Item(ProjectModElements instance) {
		super(instance, 59);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(TabmodItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(5).saturation(0.5f).meat().build()));
			setRegistryName("caracorn_meat_2");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 40;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
