
package net.mcreator.project.item;

@ProjectModElements.ModElement.Tag
public class IngottitanearmorArmorItem extends ProjectModElements.ModElement {

	@ObjectHolder("project:ingottitanearmor_armorhelmet")
	public static final Item helmet = null;

	@ObjectHolder("project:ingottitanearmor_armorbody")
	public static final Item body = null;

	@ObjectHolder("project:ingottitanearmor_armorlegs")
	public static final Item legs = null;

	@ObjectHolder("project:ingottitanearmor_armorboots")
	public static final Item boots = null;

	public IngottitanearmorArmorItem(ProjectModElements instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 60;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{8, 24, 20, 8}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 36;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "ingottitanearmor_armor";
			}

			public float getToughness() {
				return 0f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(TabmodItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "project:textures/models/armor/ingottitanearmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("ingottitanearmor_armorhelmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(TabmodItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "project:textures/models/armor/ingottitanearmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("ingottitanearmor_armorbody"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(TabmodItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "project:textures/models/armor/ingottitanearmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("ingottitanearmor_armorlegs"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(TabmodItemGroup.tab)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "project:textures/models/armor/ingottitanearmor_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("ingottitanearmor_armorboots"));
	}

}
