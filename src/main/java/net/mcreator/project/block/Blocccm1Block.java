
package net.mcreator.project.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.project.itemgroup.TabmodItemGroup;
import net.mcreator.project.ProjectModElements;

import java.util.List;
import java.util.Collections;

@ProjectModElements.ModElement.Tag
public class Blocccm1Block extends ProjectModElements.ModElement {
	@ObjectHolder("project:blocccm_1")
	public static final Block block = null;
	public Blocccm1Block(ProjectModElements instance) {
		super(instance, 72);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(TabmodItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.SAND).hardnessAndResistance(0.8999999999999999f, 5f).lightValue(0));
			setRegistryName("blocccm_1");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(PlantchampBlock.block, (int) (1)));
		}
	}
}
