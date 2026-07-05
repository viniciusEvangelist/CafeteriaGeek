package CafeteriaGeek.servico;
import CafeteriaGeek.modelo.Pedido;
import java.util.List;
import java.util.ArrayList;

public class CadastroPedido {
    private List<Pedido> pedidos;
    public CadastroPedido(){
        pedidos = new ArrayList<>();
    }
    public void cadastrar(Pedido p){
        pedidos.add(p);
    }
    public Pedido pesquisar(int numero){
        for (Pedido pedido : pedidos){
            if (pedido.getNumero() == numero){
                return pedido;
            }
        }
        return null;
    }
    public boolean atualizar(int numero, Pedido p){
        for (int i = 0; i < pedidos.size(); i++){
            if (pedidos.get(i).getNumero() == numero){
                pedidos.set(i, p);
                return true;
            }
        }
        return false;
    }
    public boolean remover(int numero){
        Pedido pedido = pesquisar(numero);
        if (pedido != null){
            pedidos.remove(pedido);
            return true;
        }
        return false;
    }
    public List<Pedido> listar(){
        return pedidos;
    }
}
