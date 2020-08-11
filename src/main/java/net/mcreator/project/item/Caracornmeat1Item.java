
package net.mcreator.project.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.project.procedures.Caracornmeat1FoodEatenProcedure;
import net.mcreator.project.itemgroup.TabmodItemGroup;
import net.mcreator.project.ProjectModElements;

import java.util.Map;
import java.util.HashMap;

@ProjectModElements.ModElement.Tag
public class Caracornmeat1Item extends ProjectModElements.ModElement {
	@ObjectHolder("project:caracornmeat_1")
	public static final Item block = null;
	public Caracornmeat1Item(ProjectModElements instance) {
		super(instance, 57);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(TabmodItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(1).saturation(0.1f).meat().build()));
			setRegistryName("caracornmeat_1");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
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
				Caracornmeat1FoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
