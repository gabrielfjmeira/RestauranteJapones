public class Uramaki extends Prato{
    private float gramasArroz;
    private float gramasCarne;
    private float gramasPhiladelphia;

    public Uramaki(int codigo, String nome, String descricao, float valor, float gramasArroz, float gramasCarne, float gramasPhiladelphia) {
        super(codigo, nome, descricao, valor);
        this.gramasArroz = gramasArroz;
        this.gramasCarne = gramasCarne;
        this.gramasPhiladelphia = gramasPhiladelphia;
    }

    public float getGramasArroz() {
        return gramasArroz;
    }

    public float getGramasCarne() {
        return gramasCarne;
    }

    public float getGramasPhiladelphia() {
        return gramasPhiladelphia;
    }
}
