public class Sashimi extends Prato{
    private float gramasCarne;
    public Sashimi(int codigo, String nome, String descricao, float valor, float gramasCarne) {
        super(codigo, nome, descricao, valor);
        this.gramasCarne = gramasCarne;
    }

    public float getGramasCarne() {
        return gramasCarne;
    }
}
