package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.PontosInsuficientesException;

public class ClienteVIP extends Cliente {
    protected static final double TAXA_CONVERSAO = 10.0;
    public ClienteVIP(String nome, String cpf){
        super(nome, cpf);
    }
    @Override
    public int calcularXP(double valorCompra){
        return (int) (valorCompra * 2);
    }
    public void pagarComXP(double valorTotal) throws PontosInsuficientesException{
        double pontosNecessarios = valorTotal * TAXA_CONVERSAO;
        if(xp < pontosNecessarios){
            throw new PontosInsuficientesException(" o cliente nao possui pontos o suficientes para realizar a compra");
        }
        xp -= (int) pontosNecessarios;
        System.out.println("compra realizada com sucesso!! \nsaldo restante: " + xp);
    }
    @Override
    public String toString() {
        return super.toString() + "\nTipo: VIP";
    }
}
