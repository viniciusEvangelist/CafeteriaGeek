package CafeteriaGeek.modelo;

public class Bebida extends Produto {
    private String tamanho;
    private int cafeinaMg;
    public Bebida(String codigo, String nome, String tamanho, int precoBase, int estoque, int cafeinaMg){
        super(codigo, nome, precoBase, estoque);
        this.tamanho = tamanho;
        this.cafeinaMg = cafeinaMg;
    }
    @Override
    public String toString() {
        return super.toString() + "\nTamanho: " + tamanho + "\nCafeína (mg): " + cafeinaMg;
    }

}
