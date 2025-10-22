package controller;

import model.*;

public class ContaController {

    private Banco banco;

    public ContaController(Banco banco) {
        this.banco = banco;
    }

    // --- MÉTODOS DE CONTA CORRENTE (CC) ---

    public String criarContaCorrente() {
        if (!banco.existeCliente()) {
            return "Erro: Crie um Cliente primeiro.";
        }
        if (banco.existeContaCorrente()) {
            return "Erro: Uma Conta Corrente já existe.";
        }

        Cliente titular = banco.getCliente();
        ContaCorrente novaCC = new ContaCorrente(titular);
        banco.setContaCorrente(novaCC);

        return "Conta Corrente N.º " + novaCC.getNumero() + " / Ag. " + novaCC.getAgencia() +
                "\nCriada para: " + titular.getNome();
    }

    public String mostrarContaCorrente() {
        if (!banco.existeContaCorrente()) {
            return "Nenhuma Conta Corrente criada.";
        }
        return "--- Dados da Conta Corrente ---\n" + banco.getContaCorrente().toString();
    }

    public String depositarContaCorrente(double valor) {
        if (!banco.existeContaCorrente()) {
            return "Nenhuma Conta Corrente criada.";
        }
        return banco.getContaCorrente().depositar(valor);
    }

    public String sacarContaCorrente(double valor) {
        if (!banco.existeContaCorrente()) {
            return "Nenhuma Conta Corrente criada.";
        }
        return banco.getContaCorrente().sacar(valor);
    }

    public String transferirDeContaCorrente(double valor) {
        if (!banco.existeContaCorrente()) {
            return "Erro: Conta Corrente (origem) não existe.";
        }
        if (!banco.existeContaPoupanca()) {
            return "Erro: Conta Poupança (destino) não existe.";
        }

        ContaCorrente origem = banco.getContaCorrente();
        ContaPoupanca destino = banco.getContaPoupanca();

        return origem.transferir(destino, valor);
    }

    public String excluirContaCorrente() {
        if (!banco.existeContaCorrente()) {
            return "Nenhuma Conta Corrente criada.";
        }
        banco.excluirContaCorrente();
        return "Conta Corrente excluída.";
    }

    // --- MÉTODOS DE CONTA POUPANÇA (CP) ---

    public String criarContaPoupanca() {
        if (!banco.existeCliente()) {
            return "Erro: Crie um Cliente primeiro.";
        }
        if (banco.existeContaPoupanca()) {
            return "Erro: Uma Conta Poupança já existe.";
        }
        Cliente titular = banco.getCliente();
        ContaPoupanca novaCP = new ContaPoupanca(titular);
        banco.setContaPoupanca(novaCP);

        return "Conta Poupança N.º " + novaCP.getNumero() + " / Ag. " + novaCP.getAgencia() +
                "\nCriada para: " + titular.getNome();
    }

    public String mostrarContaPoupanca() {
        if (!banco.existeContaPoupanca()) {
            return "Nenhuma Conta Poupança criada.";
        }
        return "--- Dados da Conta Poupança ---\n" + banco.getContaPoupanca().toString();
    }

    public String depositarContaPoupanca(double valor) {
        if (!banco.existeContaPoupanca()) {
            return "Nenhuma Conta Poupança criada.";
        }
        return banco.getContaPoupanca().depositar(valor);
    }

    public String sacarContaPoupanca(double valor) {
        if (!banco.existeContaPoupanca()) {
            return "Nenhuma Conta Poupança criada.";
        }
        return banco.getContaPoupanca().sacar(valor);
    }

    public String transferirDeContaPoupanca(double valor) {
        if (!banco.existeContaPoupanca()) {
            return "Erro: Conta Poupança (origem) não existe.";
        }
        if (!banco.existeContaCorrente()) {
            return "Erro: Conta Corrente (destino) não existe.";
        }

        ContaPoupanca origem = banco.getContaPoupanca();
        ContaCorrente destino = banco.getContaCorrente();

        return origem.transferir(destino, valor);
    }

    public String excluirContaPoupanca() {
        if (!banco.existeContaPoupanca()) {
            return "Nenhuma Conta Poupança criada.";
        }
        banco.excluirContaPoupanca();
        return "Conta Poupança excluída.";
    }
}