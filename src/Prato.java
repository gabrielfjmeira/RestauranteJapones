public class Prato implements Comida{
    private int codigo;
    private String nome;
    private String descricao;
    private float valor;

    public Prato(int codigo, String nome, String descricao, float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public float getValor() {
        return valor;
    }
}
