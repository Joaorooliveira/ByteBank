package model;

public class ContaCorrente extends Conta {

    private static final double TAXA_SAQUE = 6.00;

    public ContaCorrente(Cliente titular) {
        super(titular);
    }

    @Override
    public String sacar(double valor) {
        if (valor <= 0) {
            return "Saque falhou: Valor inválido.";
        }

        double valorTotalComTaxa = valor + TAXA_SAQUE;

        if (this.saldo >= valorTotalComTaxa) {
            this.saldo -= valorTotalComTaxa;
            return "Saque de R$" + valor + " (taxa R$" + TAXA_SAQUE + ") realizado. Saldo atual: R$" + this.saldo;
        } else {
            return "Saque falhou: Saldo insuficiente (R$" + this.saldo + ") para sacar R$" + valor + " + taxa de R$" + TAXA_SAQUE;
        }
    }
}