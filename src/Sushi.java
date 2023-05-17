public class Sushi extends Prato{
    private float gramasArroz;
    private float gramasCarne;
    public Sushi(int codigo, String nome, String descricao, float valor, float gramasArroz, float gramasCarne) {
        super(codigo, nome, descricao, valor);
        this.gramasArroz = gramasArroz;
        this.gramasCarne = gramasCarne;
    }

    public float getGramasArroz() {
        return gramasArroz;
    }

    public float getGramasCarne() {
        return gramasCarne;
    }
}
