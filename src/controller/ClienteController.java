package controller;

import model.Banco;
import model.Cliente;

public class ClienteController {

    private Banco banco;

    public ClienteController(Banco banco) {
        this.banco = banco;
    }

    public String criarCliente(String nome, int cpf) {
        if (banco.existeCliente()) {
            return "Erro: Um cliente já existe. Exclua o atual para criar um novo.";
        }

        Cliente novoCliente = new Cliente(nome, cpf);
        banco.setCliente(novoCliente);

        return "Cliente " + novoCliente.getNome() + " criado com sucesso!";
    }

    public String mostrarCliente() {
        if (!banco.existeCliente()) {
            return "Nenhum cliente foi criado ainda.";
        }
        Cliente cliente = banco.getCliente();
        return "--- Dados do Cliente ---\n" +
                "Nome: " + cliente.getNome() + "\n" +
                "Cpf : " + cliente.getCpf();
    }

    public String editarCliente(int campo, String novoValor) {
        if (!banco.existeCliente()) {
            return "Nenhum cliente foi criado ainda.";
        }
        Cliente cliente = banco.getCliente();

        switch (campo) {
            case 1:
                cliente.setNome(novoValor);
                return "Nome atualizado com sucesso!";
            case 2:
                try {
                    int novoCpf = Integer.parseInt(novoValor);
                    cliente.setCpf(novoCpf);
                    return "CPF atualizado com sucesso!";
                } catch (NumberFormatException e) {
                    return "Erro: CPF deve ser um número.";
                }
            default:
                return "Opção de edição inválida.";
        }
    }

    public String excluirCliente() {
        if (!banco.existeCliente()) {
            return "Nenhum cliente foi incluido ainda.";
        }
        banco.excluirCliente();
        return "Cliente e todas as suas contas foram excluidos!";
    }
}