package view;

import controller.ClienteController;
import controller.ContaController;
import java.util.Scanner;

public class MenuView {

    private Scanner sc;
    private ClienteController clienteController;
    private ContaController contaController;

    public MenuView(ClienteController clienteController, ContaController contaController) {
        this.clienteController = clienteController;
        this.contaController = contaController;
        this.sc = new Scanner(System.in);
    }

    private void limparTela() {
        for (int i = 0; i < 30; i++) {
            System.out.println("                           ");
        }
    }

    private double pedirValorDouble(String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextDouble()) {
            System.out.println("Erro: Por favor, digite um número válido (ex: 50.00).");
            System.out.print(mensagem);
            sc.next(); // Limpa o buffer
        }
        double valor = sc.nextDouble();
        sc.nextLine(); // Limpa o buffer
        return valor;
    }

    public void mostrarMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n--- Bem vindo ao ByteBank ---");
            System.out.println("1. Menu Cliente");
            System.out.println("2. Menu Conta Corrente");
            System.out.println("3. Menu Conta Poupanca");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer
            limparTela();

            switch(opcao) {
                case 1:
                    mostrarMenuCliente();
                    break;
                case 2:
                    mostrarMenuContaCorrente();
                    break;
                case 3:
                    mostrarMenuContaPoupanca();
                    break;
            }
        } while(opcao != 0);

        System.out.println("Obrigado por usar o ByteBank!");
        sc.close();
    }

    private void mostrarMenuCliente() {
        int opcao;
        do {
            System.out.println("\n--- Menu Cliente ---");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Mostrar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer
            limparTela();
            String resultado;

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    int cpf = sc.nextInt();
                    sc.nextLine(); // Limpar buffer
                    resultado = clienteController.criarCliente(nome, cpf);
                    System.out.println(resultado);
                    break;
                case 2:
                    resultado = clienteController.mostrarCliente();
                    System.out.println(resultado);
                    break;
                case 3:
                    System.out.println("O que deseja editar?");
                    System.out.println("1. Nome");
                    System.out.println("2. CPF");
                    int campo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o novo valor: ");
                    String valor = sc.nextLine();
                    resultado = clienteController.editarCliente(campo, valor);
                    System.out.println(resultado);
                    break;
                case 4:
                    resultado = clienteController.excluirCliente();
                    System.out.println(resultado);
                    break;
            }
        } while(opcao != 0);
    }

    private void mostrarMenuContaCorrente() {
        int opcao;
        do {
            System.out.println("\n--- Menu Conta Corrente ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Mostrar Dados/Saldo");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar (Taxa R$ 6,00)");
            System.out.println("5. Transferir (para Poupança)");
            System.out.println("6. Excluir Conta");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            limparTela();
            String resultado;
            double valor;

            switch (opcao) {
                case 1:
                    resultado = contaController.criarContaCorrente();
                    System.out.println(resultado);
                    break;
                case 2:
                    resultado = contaController.mostrarContaCorrente();
                    System.out.println(resultado);
                    break;
                case 3:
                    valor = pedirValorDouble("Digite o valor a depositar: R$");
                    resultado = contaController.depositarContaCorrente(valor);
                    System.out.println(resultado);
                    break;
                case 4:
                    valor = pedirValorDouble("Digite o valor a sacar: R$");
                    resultado = contaController.sacarContaCorrente(valor);
                    System.out.println(resultado);
                    break;
                case 5:
                    valor = pedirValorDouble("Digite o valor a transferir (CC -> CP): R$");
                    resultado = contaController.transferirDeContaCorrente(valor);
                    System.out.println(resultado);
                    break;
                case 6:
                    resultado = contaController.excluirContaCorrente();
                    System.out.println(resultado);
                    break;
            }
        } while(opcao != 0);
    }

    private void mostrarMenuContaPoupanca() {
        int opcao;
        do {
            System.out.println("\n--- Menu Conta Poupança ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Mostrar Dados/Saldo");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar (Sem taxa)");
            System.out.println("5. Transferir (para Corrente)");
            System.out.println("6. Excluir Conta");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            limparTela();
            String resultado;
            double valor;

            switch (opcao) {
                case 1:
                    resultado = contaController.criarContaPoupanca();
                    System.out.println(resultado);
                    break;
                case 2:
                    resultado = contaController.mostrarContaPoupanca();
                    System.out.println(resultado);
                    break;
                case 3:
                    valor = pedirValorDouble("Digite o valor a depositar: R$");
                    resultado = contaController.depositarContaPoupanca(valor);
                    System.out.println(resultado);
                    break;
                case 4:
                    valor = pedirValorDouble("Digite o valor a sacar: R$");
                    resultado = contaController.sacarContaPoupanca(valor);
                    System.out.println(resultado);
                    break;
                case 5:
                    valor = pedirValorDouble("Digite o valor a transferir (CP -> CC): R$");
                    resultado = contaController.transferirDeContaPoupanca(valor);
                    System.out.println(resultado);
                    break;
                case 6:
                    resultado = contaController.excluirContaPoupanca();
                    System.out.println(resultado);
                    break;
            }
        } while(opcao != 0);
    }
}