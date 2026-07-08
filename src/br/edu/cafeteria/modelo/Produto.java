package br.edu.cafeteria.modelo;
import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
public abstract class Produto {
    protected String codigo;
    protected String nome;
    protected double precoBase;
    protected int estoque;

    public Produto(String codigo, String nome, double precoBase, int estoque){
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.estoque = estoque;
    }
    public double getPreco(){
        return precoBase;
    }
    public void reduzirEstoque(int quantidade) throws EstoqueInsuficienteException{ //throws (pode acontecer)
        if(!temEstoque(quantidade)){
            throw new EstoqueInsuficienteException("estoque insuficiente para o produto "+ nome);//throw (aconteceu)
        }

        estoque -= quantidade;
    }
    public void devolverEstoque(int quantidade){
        estoque += quantidade;
    }
    public boolean temEstoque(int quantidade){
       if (estoque >= quantidade){
           return true;
       }
       return false;
    }
    public String getCodigo(){
        return codigo;
    }
    public String getNome(){
        return nome;
    }
    public int getEstoque(){
        return estoque;
    }
    @Override
    public String toString() {
        return "Código: " + codigo + "\nNome: " + nome + "\nPreço: R$ " + precoBase + "\nEstoque: " + estoque;
    }
}
