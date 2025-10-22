package model;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente titular) {
        super(titular);
    }

    @Override
    public String sacar(double valor) {
        if (valor <= 0) {
            return "Saque falhou: Valor inválido.";
        }

        if (this.saldo >= valor) {
            this.saldo -= valor;
            return "Saque de R$" + valor + " realizado (sem taxa). Saldo atual: R$" + this.saldo;
        } else {
            return "Saque falhou: Saldo insuficiente (R$" + this.saldo + ") para sacar R$" + valor;
        }
    }
}