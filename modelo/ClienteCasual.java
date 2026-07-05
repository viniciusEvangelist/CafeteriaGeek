package br.edu.cafeteria.modelo;

// Null Object Pattern: representa uma venda avulsa, sem cliente cadastrado,
// evitando checagem de nulo em Pedido.finalizar().
public class ClienteCasual extends Cliente {
    public ClienteCasual(){
        super("Cliente Casual", "N/A");
    }
    @Override
    public int calcularXP(double valorCompra){
        return 0;
    }
    @Override
    public String toString() {
        return super.toString() + "\nTipo: Casual (sem cadastro)";
    }
}
