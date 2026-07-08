package br.edu.cafeteria.modelo;

public class ItemPedido {
    protected Produto produto;
    protected int quantidade;

    public ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public double subtotal(){
        return produto.getPreco()*quantidade; // o java ja sabe que produto pode ser br.edu.cafeteria.modelo.Comida ou br.edu.cafeteria.modelo.Bebida, ja que ambas herdam br.edu.cafeteria.modelo.Produto
    }
    public Produto getProduto(){
        return produto;
    }
    public int getQuantidade(){
        return quantidade;
    }
    @Override
    public String toString() {
        return produto.getNome() + " - Quantidade: " + quantidade + " - Subtotal: R$ " + subtotal();
    }
}
