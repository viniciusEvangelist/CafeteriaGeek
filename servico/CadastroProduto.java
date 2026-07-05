package br.edu.cafeteria.servico;

import br.edu.cafeteria.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class CadastroProduto {
    protected List<Produto> produtos;
    public CadastroProduto(){
        produtos = new ArrayList<>();
    }
    public void cadastrar(Produto produto){
        produtos.add(produto);
    }
    public Produto pesquisar(String codigo){
        for (Produto produto : produtos){
            if (produto.getCodigo().equals(codigo)){
                return produto;
            }
        }
        return null;
    }
    public boolean atualizar(String codigo, Produto novoProduto){
        for (int i = 0; i<produtos.size(); i++){
            if (produtos.get(i).getCodigo().equals(codigo)){
                produtos.set(i, novoProduto); //substitui um elemento da lista
                return true;
            }
        }
        return false;
    }
    public boolean remover(String codigo){
        Produto produto = pesquisar(codigo);
        if (produto != null){
            produtos.remove(produto);
            return true;
        }
        return false;
    }
    public List<Produto> listar(){
        return produtos;
    }
}
