package br.edu.cafeteria.modelo;

public abstract class Cliente{

    protected String nome;
    protected String cpf;
    protected int xp;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.xp = 0;
    }

    public abstract int calcularXP(double valorCompra);

    public void adicionarXP(int pontos) {
        xp += pontos;
    }

    public int getXP() {
        return xp;
    }
    public String getCpf(){
        return cpf;
    }
    public String getNome(){
        return nome;
    }
    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nXP: " + xp;
    }
}
