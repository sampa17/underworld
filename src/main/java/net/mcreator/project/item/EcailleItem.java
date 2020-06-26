
package net.mcreator.project.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.project.itemgroup.TabmodItemGroup;
import net.mcreator.project.ProjectModElements;

@ProjectModElements.ModElement.Tag
public class EcailleItem extends ProjectModElements.ModElement {
	@ObjectHolder("project:ecaille")
	public static final Item block = null;
	public EcailleItem(ProjectModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabmodItemGroup.tab).maxStackSize(64));
			setRegistryName("ecaille");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
