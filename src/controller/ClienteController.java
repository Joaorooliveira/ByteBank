package controller;

import  model.Cliente;
import view.Main;

import java.util.Scanner;

public class ClienteController {
    private Scanner sc = new Scanner(System.in);
    private int opcao;
    private Cliente cliente;

    public void excluirCliente(){
        if(this.cliente == null){
            System.out.println("Nenhum cliente foi incluido ainda");
        }else{
            System.out.println("Cliente excluido com sucesso!");
            this.cliente = null;
        }
    }
    public void mostrarCliente(){
        if(this.cliente == null){
            System.out.println("Nenhum cliente foi criado ainda");
        }else{
            System.out.println("Nome do cliente: "+this.cliente.getNome());
            System.out.println("Cpf : "+this.cliente.getCpf());
        }
    }
    public void criarCliente(){

        this.cliente = new Cliente();
        System.out.println("Digite o nome do cliente:");
        this.cliente.setNome(sc.nextLine());
        System.out.println("Digite o cpf:");
        this.cliente.setCpf(sc.nextInt());
        Main.limparTela();

    }
    public void mostrarMenu(){
        do{
            System.out.println("---Menu Cliente---");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Mostrar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Excluir Cliente");
            opcao = sc.nextInt();
            sc.nextLine();
            Main.limparTela();
            switch (opcao){
                case 1 -> criarCliente();
                case 2 -> mostrarCliente();
                case 4 -> excluirCliente();
            }
        }while(opcao!=0);
    }

}
