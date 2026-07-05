package br.edu.cafeteria.modelo;

import br.edu.cafeteria.servico.Promocional;
import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.excecao.PontosInsuficientesException;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    protected static int contador = 1; //esse atributo pertence a classe e nao ao objeto
    protected int numero;
    protected Cliente cliente;
    protected Atendente atendente;
    protected ArrayList<ItemPedido> itens; //guarda objetos do tipo br.edu.cafeteria.modelo.ItemPedido, preferi usar um array aqui porque nao tenho certeza do tamanho do vetor que eu precisaria declarar
    protected Promocional promocao;

    public Pedido(Cliente cliente, Atendente atendente){
        this.numero = contador++;
        this.cliente = cliente;
        this.atendente = atendente;
        this.itens = new ArrayList<>();
        this.promocao = null;
    }
    public Pedido(Atendente atendente){
        this(new ClienteCasual(), atendente);
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
        double totalComida = 0;
        double totalBebida = 0;
        for(ItemPedido item : itens){
            if (item.getProduto() instanceof Bebida){
                totalBebida += item.subtotal();
            } else {
                totalComida += item.subtotal();
            }
        }
        if (promocao != null){
            totalBebida = promocao.aplicarDesconto(totalBebida);
        }
        return totalComida + totalBebida;
    }
    public void finalizar(){
        double total = calcularTotal();
        int pontos = cliente.calcularXP(total);
        cliente.adicionarXP(pontos);
    }
    public void finalizarComXP() throws PontosInsuficientesException{
        if (!(cliente instanceof ClienteVIP)){
            throw new IllegalStateException("Pagamento com XP disponivel apenas para clientes VIP");
        }
        double total = calcularTotal();
        ((ClienteVIP) cliente).pagarComXP(total);
    }
    public int getNumero(){
        return numero;
    }
    public List<ItemPedido> getItens(){
        return itens;
    }
}
