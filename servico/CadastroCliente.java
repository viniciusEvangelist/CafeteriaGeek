package br.edu.cafeteria.servico;
import br.edu.cafeteria.modelo.Cliente;
import java.util.ArrayList;
import java.util.List;

public class CadastroCliente {
    private List<Cliente> clientes;
    public CadastroCliente(){
        clientes = new ArrayList<>();
    }
    public void cadastrar(Cliente c){
        clientes.add(c);
    }
    public Cliente pesquisarPorCpf(String cpf){
        for (Cliente cliente : clientes){
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }
    public boolean atualizar(String cpf, Cliente c){
        for (int i = 0; i < clientes.size(); i++){
            if (clientes.get(i).getCpf().equals(cpf)){
                clientes.set(i, c);
                return true;
            }
        }
        return false;
    }
    public boolean remover(String cpf){
        Cliente cliente = pesquisarPorCpf(cpf);
        if (cliente != null){
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
    public List<Cliente> listar(){
        return clientes;
    }
}
