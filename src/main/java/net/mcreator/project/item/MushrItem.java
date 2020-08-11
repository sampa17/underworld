
package net.mcreator.project.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.project.procedures.MushrFoodEatenProcedure;
import net.mcreator.project.itemgroup.TabmodItemGroup;
import net.mcreator.project.ProjectModElements;

import java.util.Map;
import java.util.HashMap;

@ProjectModElements.ModElement.Tag
public class MushrItem extends ProjectModElements.ModElement {
	@ObjectHolder("project:mushr")
	public static final Item block = null;
	public MushrItem(ProjectModElements instance) {
		super(instance, 70);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(TabmodItemGroup.tab).maxStackSize(1).food((new Food.Builder()).hunger(6).saturation(0.4f).build()));
			setRegistryName("mushr");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 30;
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.DRINK;
		}

		@Override
		public net.minecraft.util.SoundEvent getEatSound() {
			return net.minecraft.util.SoundEvents.ENTITY_GENERIC_DRINK;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				MushrFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
