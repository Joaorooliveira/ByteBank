package view;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;

import java.util.Locale;
import java.util.Scanner;
import controller.ClienteController;
public class Main {
    public static void limparTela(){
        for (int i = 0; i < 30; i++) {
            System.out.println("                           ");

        }
    }
    public static void main(String[] args) {
        int opcao;
        Scanner sc = new Scanner(System.in);
        ClienteController clienteController = new ClienteController();

        do{
            System.out.println("Bem vindo ao menu do ByteBank");
            System.out.println("1. Cliente");
            System.out.println("2. Conta Corrente");
            System.out.println("3. Conta Poupanca");
            System.out.println("0. Sair");
            opcao = sc.nextInt();
            sc.nextLine();
            limparTela();
            switch(opcao){
                case 1 -> {
                    clienteController.mostrarMenu();

                }
            }
        }while(opcao!=0);
    }
//        Cliente cliente1 = new Cliente("Joao",03030000);
//        ContaCorrente contaCorrente = new ContaCorrente(123,"Bradesco",5000,cliente1);
//        System.out.println("Conta Corrente:"+contaCorrente);


    }
