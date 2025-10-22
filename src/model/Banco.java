package model;

public class Banco {

    private Cliente cliente;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;

    public Banco() { }

    // --- CLIENTE ---
    public Cliente getCliente() { return this.cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void excluirCliente() {
        this.cliente = null;
        this.contaCorrente = null;
        this.contaPoupanca = null;
    }
    public boolean existeCliente() { return this.cliente != null; }

    // --- CONTA CORRENTE ---
    public ContaCorrente getContaCorrente() { return contaCorrente; }
    public void setContaCorrente(ContaCorrente contaCorrente) { this.contaCorrente = contaCorrente; }
    public boolean existeContaCorrente() { return this.contaCorrente != null; }
    public void excluirContaCorrente() { this.contaCorrente = null; }

    // --- CONTA POUPANÇA ---
    public ContaPoupanca getContaPoupanca() { return contaPoupanca; }
    public void setContaPoupanca(ContaPoupanca contaPoupanca) { this.contaPoupanca = contaPoupanca; }
    public boolean existeContaPoupanca() { return this.contaPoupanca != null; }
    public void excluirContaPoupanca() { this.contaPoupanca = null; }
}