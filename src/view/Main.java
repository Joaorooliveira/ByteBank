package view;

import controller.ClienteController;
import controller.ContaController;
import model.Banco;

public class Main {
    public static void main(String[] args) {

        Banco byteBank = new Banco();


        ClienteController clienteController = new ClienteController(byteBank);
        ContaController contaController = new ContaController(byteBank);


        MenuView menuView = new MenuView(clienteController, contaController);


        menuView.mostrarMenuPrincipal();
    }
}