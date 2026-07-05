package CafeteriaGeek.modelo;

public class Comida extends Produto {
    private int tempoPreparo;
    private boolean vegano;
    private boolean semGluten;
    public Comida(String codigo, String nome, double precoBase, int estoque, int tempoPreparo, boolean vegano, boolean semGluten){
        super(codigo, nome, precoBase, estoque);
        this.tempoPreparo = tempoPreparo;
        this.vegano = vegano;
        this.semGluten = semGluten;
    }
    @Override
    public String toString() {
        return super.toString() + "\nTempo de preparo: " + tempoPreparo + "\nVegano: " + vegano + "\nSem glúten: " + semGluten;
    }
}
