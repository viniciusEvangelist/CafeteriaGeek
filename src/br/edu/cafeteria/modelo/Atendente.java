package br.edu.cafeteria.modelo;

public class Atendente {
    private String nome;
    private String matricula;

    public Atendente(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
    }
    public String getNome(){
        return nome;
    }
    public String getMatricula(){
        return matricula;
    }
    @Override
    public String toString() {
        return "Atendente: " + nome + " (Matrícula: " + matricula + ")";
    }
}
