package model;

public class ContaCorrente extends Conta{

    public ContaCorrente(int numero, String agencia, double saldo, Cliente titular) {
        super(numero, agencia, saldo, titular);
    }

    public ContaCorrente() {
    }
}
