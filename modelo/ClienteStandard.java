package CafeteriaGeek.modelo;

public class ClienteStandard extends Cliente {

    public ClienteStandard(String nome, String cpf){
        super(nome, cpf);
    }
    @Override
    public int calcularXP(double valorCompra){
        return (int)valorCompra;
    }
    @Override
    public String toString() {
        return super.toString() + "\nTipo: Standard";
    }
}
