package CafeteriaGeek.modelo;

public class ItemPedido {
    protected Produto produto;
    protected int quantidade;

    public ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public double subtotal(){
        return produto.getPreco()*quantidade; // o java ja sabe que produto pode ser CafeteriaGeek.modelo.Comida ou CafeteriaGeek.modelo.Bebida, ja que ambas herdam CafeteriaGeek.modelo.Produto
    }
    @Override
    public String toString() {
        return produto.getNome() + " - Quantidade: " + quantidade + " - Subtotal: R$ " + subtotal();
    }
}
