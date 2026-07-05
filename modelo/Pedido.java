package CafeteriaGeek.modelo;

import CafeteriaGeek.servico.Promocional;
import CafeteriaGeek.excecao.EstoqueInsuficienteException;
import java.util.ArrayList;

public class Pedido {
    protected static int contador = 1; //esse atributo pertence a classe e nao ao objeto
    protected int numero;
    protected Cliente cliente;
    protected ArrayList<ItemPedido> itens; //guarda objetos do tipo CafeteriaGeek.modelo.ItemPedido, preferi usar um array aqui porque nao tenho certeza do tamanho do vetor que eu precisaria declarar
    protected Promocional promocao;

    public Pedido(Cliente cliente){
        this.numero = contador++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.promocao = null;
    }
    public void aplicarPromocao(Promocional promocao) {
        if (this.promocao == null) {
            this.promocao = promocao;
        }
    }
    public void adicionarItem(Produto produto) throws EstoqueInsuficienteException{
        adicionarItem(produto, 1);
    }
    public void adicionarItem(Produto produto, int quantidade) throws EstoqueInsuficienteException{
        produto.reduzirEstoque(quantidade);
        ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }
    public double calcularTotal(){
        double total = 0;
        for(ItemPedido item : itens){
            total += item.subtotal();
        }
        if (promocao != null){
            total = promocao.aplicarDesconto(total);
        }
        return total;
    }
    public void finalizar(){
        double total = calcularTotal();
        int pontos = cliente.calcularXP(total);
        cliente.adicionarXP(pontos);
    }
    public int getNumero(){
        return numero;
    }
}
