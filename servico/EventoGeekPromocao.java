package br.edu.cafeteria.servico;

public class EventoGeekPromocao implements Promocional{
    @Override
    public double aplicarDesconto(double valor){
        return valor * 0.9;
    }
}
