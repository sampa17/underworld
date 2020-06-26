
public static class Modelgeometrydolphin extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer tail_fin;
	private final ModelRenderer back_fin;
	private final ModelRenderer left_fin;
	private final ModelRenderer right_fin;
	private final ModelRenderer nose;

	public Modelgeometrydolphin() {
		textureWidth = 16;
		textureHeight = 16;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, -3.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 4.0F, 6.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -3.0F);
		body.setTextureOffset(0, 13).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 3.0F, 10.0F, 0.0F, true);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 21.5F, 11.0F);
		tail.setTextureOffset(0, 8).addBox(-1.0F, 0.5F, -4.0F, 2.0F, 1.0F, 5.0F, 0.0F, true);

		tail_fin = new ModelRenderer(this);
		tail_fin.setRotationPoint(0.0F, 21.5F, 20.0F);

		back_fin = new ModelRenderer(this);
		back_fin.setRotationPoint(0.0F, 17.0F, 4.0F);

		left_fin = new ModelRenderer(this);
		left_fin.setRotationPoint(-3.0F, 23.0F, -1.0F);
		left_fin.setTextureOffset(0, 0).addBox(-7.0F, -1.0F, -1.0F, 6.0F, 1.0F, 4.0F, 0.0F, true);

		right_fin = new ModelRenderer(this);
		right_fin.setRotationPoint(3.0F, 23.0F, -1.0F);
		right_fin.setTextureOffset(0, 0).addBox(1.0F, -1.0F, -1.0F, 6.0F, 1.0F, 4.0F, 0.0F, true);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 24.0F, -13.0F);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		tail_fin.render(matrixStack, buffer, packedLight, packedOverlay);
		back_fin.render(matrixStack, buffer, packedLight, packedOverlay);
		left_fin.render(matrixStack, buffer, packedLight, packedOverlay);
		right_fin.render(matrixStack, buffer, packedLight, packedOverlay);
		nose.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}