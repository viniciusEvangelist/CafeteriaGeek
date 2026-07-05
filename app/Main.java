package br.edu.cafeteria.app;
import br.edu.cafeteria.modelo.*;
import br.edu.cafeteria.servico.*;
import br.edu.cafeteria.excecao.*;

public class Main {
    public static void main(String[] args) throws EstoqueInsuficienteException {
        CadastroProduto cadastroProduto = new CadastroProduto();
        CadastroCliente cadastroCliente = new CadastroCliente();
        CadastroPedido cadastroPedido = new CadastroPedido();
        Comida portalCake = new Comida("C001","Portal Cake", 10.0, 10, 20, false, false );
        Comida lembasBread = new Comida("C002","Lembas Bread", 8.0, 15, 40, true, false );
        Comida burguerVegano = new Comida("C003", "Burger Vegano", 35.0, 10, 30, true, true);
        Bebida cafeProgramador = new Bebida("B001", "Cafe do Programador", "M", 8.0, 10, 200 );
        Bebida pocaoMana = new Bebida("B002", "Pocao de Mana", "G", 15.0, 10, 0);
        cadastroProduto.cadastrar(portalCake);
        cadastroProduto.cadastrar(lembasBread);
        cadastroProduto.cadastrar(burguerVegano);
        cadastroProduto.cadastrar(cafeProgramador);
        cadastroProduto.cadastrar(pocaoMana);
        ClienteStandard cliente1 = new ClienteStandard("Lucas", "068.000.000-00");
        ClienteStandard cliente2 = new ClienteStandard("Tiago", "041.000.000-00");
        ClienteVIP cliente3 = new ClienteVIP("Geovanna", "033.000.000-00");
        cadastroCliente.cadastrar(cliente1);
        cadastroCliente.cadastrar(cliente2);
        cadastroCliente.cadastrar(cliente3);

        Atendente atendenteAlice = new Atendente("Alice", "AT001");

        Pedido pedido1 = new Pedido(cliente3, atendenteAlice);
        cadastroPedido.cadastrar(pedido1);
        System.out.println(cafeProgramador.getEstoque());
        pedido1.adicionarItem(portalCake, 2);
        pedido1.finalizar();

        // Polimorfismo por Coerção: conversão implícita (widening) de int para double,
        // sem necessidade de cast explícito.
        int gorjetaEmReais = 5;
        double totalComGorjeta = pedido1.calcularTotal() + gorjetaEmReais;
        System.out.println("Total do pedido 1 com gorjeta: R$ " + totalComGorjeta);

        // Desconto da EventoGeekPromocao deve valer somente para bebidas.
        Pedido pedidoDesconto = new Pedido(cliente1, atendenteAlice);
        cadastroPedido.cadastrar(pedidoDesconto);
        pedidoDesconto.adicionarItem(lembasBread, 1);
        pedidoDesconto.adicionarItem(cafeProgramador, 1);
        pedidoDesconto.aplicarPromocao(new EventoGeekPromocao());
        System.out.println("Total pedido com desconto (somente na bebida): R$ " + pedidoDesconto.calcularTotal());

        // Venda avulsa (sem cliente cadastrado), usando o Null Object ClienteCasual:
        // finalizar() nao lanca mais NullPointerException.
        Pedido pedidoCasual = new Pedido(atendenteAlice);
        cadastroPedido.cadastrar(pedidoCasual);
        pedidoCasual.adicionarItem(pocaoMana, 1);
        pedidoCasual.finalizar();
        System.out.println("Pedido casual (sem cliente) numero " + pedidoCasual.getNumero() + " finalizado sem erro.");

        // Pagamento com XP integrado ao fluxo do pedido. Com a TAXA_CONVERSAO atual,
        // Geovanna ainda nao acumulou XP suficiente, entao o esperado aqui e a excecao.
        Pedido pedidoXP = new Pedido(cliente3, atendenteAlice);
        cadastroPedido.cadastrar(pedidoXP);
        pedidoXP.adicionarItem(lembasBread, 1);
        try {
            pedidoXP.finalizarComXP();
        } catch (PontosInsuficientesException e) {
            System.out.println("Pagamento com XP falhou: " + e.getMessage());
        }

        // Regra de identificacao: se o CPF informado nao estiver cadastrado,
        // a venda prossegue automaticamente como cliente casual (sem beneficios).
        String cpfInformado = "000.000.000-00";
        Cliente clienteResolvido = cadastroCliente.pesquisarPorCpf(cpfInformado);
        Pedido pedidoPorCpf;
        if (clienteResolvido != null) {
            pedidoPorCpf = new Pedido(clienteResolvido, atendenteAlice);
        } 
        else {
            pedidoPorCpf = new Pedido(atendenteAlice);
        }
        cadastroPedido.cadastrar(pedidoPorCpf);
        pedidoPorCpf.adicionarItem(portalCake, 1);
        pedidoPorCpf.finalizar();
        System.out.println("CPF " + cpfInformado + " nao cadastrado -> pedido " + pedidoPorCpf.getNumero() + " tratado como cliente casual.");
       
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
