package model;

abstract public class Conta {
    private String agencia;
    private int numero;
    protected double saldo;
    private Cliente titular;

    public Conta(int numero, String agencia, double saldo, Cliente titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Conta() {
    }

    @Override
    public String toString() {
        return "agencia=" + agencia + '\'' +
                ", \nnumero=" + numero +
                ", \nsaldo=" + saldo +
                ", \ntitular=" + titular;
    }
}
