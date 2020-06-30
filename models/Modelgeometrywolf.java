
public static class Modelgeometrywolf extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leg1;

	public Modelgeometrywolf() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(1.0F, 15.745F, -5.75F);
		head.setTextureOffset(6, 9).addBox(-1.0F, 2.755F, 0.75F, 2.0F, 3.0F, 4.0F, 0.0F, true);
		head.setTextureOffset(6, 11).addBox(-2.0F, 3.755F, 1.75F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 14.0F, 2.0F);
		body.setTextureOffset(0, 16).addBox(-2.0F, 5.0F, -3.0F, 6.0F, 2.0F, 6.0F, 0.0F, true);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-0.5F, 16.0F, 7.0F);
		leg1.setTextureOffset(0, 18).addBox(-1.0F, 5.0F, -4.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
		leg1.setTextureOffset(0, 18).addBox(2.0F, 5.0F, -4.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
		leg1.setTextureOffset(0, 18).addBox(2.0F, 5.0F, -8.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
		leg1.setTextureOffset(0, 18).addBox(-1.0F, 5.0F, -8.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}