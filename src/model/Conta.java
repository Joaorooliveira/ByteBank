package model;

abstract public class Conta {

    private static final String AGENCIA_PADRAO = "0001";
    private static int SEQUENCIAL_CONTA = 1;

    protected String agencia;
    protected int numero;
    protected double saldo;
    private Cliente titular;

    public Conta(Cliente titular) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL_CONTA++;
        this.titular = titular;
        this.saldo = 0;
    }

    public String getAgencia() { return agencia; }
    public int getNumero() { return numero; }
    public Cliente getTitular() { return titular; }
    public double getSaldo() { return saldo; }


    public String depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return "Depósito de R$" + valor + " realizado. Saldo atual: R$" + this.saldo;
        } else {
            return "Valor de depósito inválido.";
        }
    }

    // O saque ainda é abstrato, mas agora retorna uma String de status
    public abstract String sacar(double valor);


    public String transferir(Conta destino, double valor) {
        if (valor <= 0) {
            return "Valor de transferência inválido.";
        }

        // Tenta sacar da origem
        String resultadoSaque = this.sacar(valor);

        // Verifica se o saque foi bem-sucedido (vamos checar a mensagem de retorno)
        if (resultadoSaque.startsWith("Saque falhou")) {
            return "Transferência falhou. Motivo: " + resultadoSaque;
        }

        // Se o saque deu certo, deposita no destino
        destino.depositar(valor);
        return "Transferência concluída. " + resultadoSaque;
    }

    // toString() para mostrar os dados da conta
    @Override
    public String toString() {
        return  "Titular: " + titular.getNome() +
                "\nAgencia: " + agencia +
                "\nNumero: " + numero +
                "\nSaldo: R$" + saldo;
    }
}