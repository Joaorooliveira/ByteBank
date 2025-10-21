package controller;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;

import java.util.Scanner;
import static view.Main.limparTela;

public class ContaController implements OperacoesBancarias{

    private int opcao;
    private Scanner sc = new Scanner(System.in);
    ContaCorrente contaCorrente = new ContaCorrente();

    public void criarContaCorrente(){

    }
    public void mostrarMenuContaCorrente(){
        do {
            System.out.println("---Conta Corrente---");
            System.out.println("1. Criar ");
            System.out.println("2. Mostrar ");
            System.out.println("3. Editar ");
            System.out.println("4. Excluir ");
            opcao = sc.nextInt();
            limparTela();
            switch (opcao) {
                case 1 -> System.out.println("teste");
            }

        }while(opcao!=0);
    }
    @Override
    public void depositar(double saldo) {

    }

    @Override
    public void sacar(double saldo) {

    }


}
