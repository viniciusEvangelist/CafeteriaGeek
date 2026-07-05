package CafeteriaGeek.app;
import CafeteriaGeek.modelo.*;
import CafeteriaGeek.servico.*;
import CafeteriaGeek.excecao.*;

public class Main {
    public static void main(String[] args) throws EstoqueInsuficienteException {
        CadastroProduto cadastroProduto = new CadastroProduto();
        CadastroCliente cadastroCliente = new CadastroCliente();
        CadastroPedido cadastroPedido = new CadastroPedido();
        Comida portalCake = new Comida("C001","Portal Cake", 10.0, 10, 20, false, false );
        Comida lembasBread = new Comida("C002","Lembas Bread", 8.0, 15, 40, true, false );
        Comida burguerVegano = new Comida("C003", "Burger Vegano", 35, 10, 30, true, true);
        Bebida cafeProgramador = new Bebida("B001", "Cafe do Programador", "M", 8, 10, 200 );
        Bebida pocaoMana = new Bebida("B002", "Pocao de Mana", "G", 15, 10, 0);
        cadastroProduto.cadastrar(portalCake);
        cadastroProduto.cadastrar(lembasBread);
        cadastroProduto.cadastrar(burguerVegano);
        cadastroProduto.cadastrar(cafeProgramador);
        cadastroProduto.cadastrar(pocaoMana);
        ClienteStandard cliente1 = new ClienteStandard("Lucas", "222.222.222-22");
        ClienteStandard cliente2 = new ClienteStandard("Tiago", "111.111.111-11");
        ClienteVIP cliente3 = new ClienteVIP("Geovanna", "000.000.000-00");
        cadastroCliente.cadastrar(cliente1);
        cadastroCliente.cadastrar(cliente2);
        cadastroCliente.cadastrar(cliente3);
        Pedido pedido1 = new Pedido(cliente3);
        cadastroPedido.cadastrar(pedido1);
        System.out.println(cafeProgramador.getEstoque());
        pedido1.adicionarItem(portalCake, 2);
        pedido1.finalizar();
        System.out.println("=== PRODUTOS ===");

        for (Produto p : cadastroProduto.listar()) {
            System.out.println(p);
            System.out.println();
        }
        System.out.println("=== CLIENTES ===");

        for (Cliente c : cadastroCliente.listar()) {
            System.out.println(c);
            System.out.println();
        }
    }
}
