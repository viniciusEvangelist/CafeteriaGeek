package CafeteriaGeek.excecao;

public class EstoqueInsuficienteException extends Exception{
    public EstoqueInsuficienteException(String mensagem){
        super(mensagem);
    }
}
