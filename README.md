# 🏧 ByteBank: Simulador de Banco Digital

![Java](https://img.shields.io/badge/Java-17+-blue?style=for-the-badge&logo=java)
![Arquitetura](https://img.shields.io/badge/Arquitetura-MVC-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-blueviolet?style=for-the-badge)

Um projeto de estudo em Java puro para console, focado em aplicar os conceitos de Programação Orientada a Objetos (POO) e arquitetura MVC.

## 📖 Sobre o Projeto

Este projeto foi desenvolvido como um desafio prático para solidificar os 4 pilares da POO e a separação de responsabilidades. Ele simula as operações básicas de um banco digital, como gerenciamento de cliente e contas, rodando inteiramente no terminal.

A arquitetura foi refatorada para o padrão **Model-View-Controller (MVC)**, garantindo que a lógica de negócio (`Model`), a interação com o usuário (`View`) e a orquestração (`Controller`) sejam totalmente independentes.

## ✨ Funcionalidades (Features)

* **Gestão de Cliente:**
    * Criar, Visualizar, Editar e Excluir o cliente único da aplicação.
* **Gestão de Contas:**
    * Criação de Conta Corrente e Conta Poupança.
    * Geração automática de número de conta e agência padrão.
    * Exclusão de contas.
* **Operações Bancárias:**
    * Depositar.
    * Sacar (com regra de negócio).
    * Transferir (entre as contas Corrente e Poupança).
* **Regras de Negócio Específicas:**
    * **Taxa de Saque:** É cobrada uma taxa fixa de `R$ 6,00` a cada saque realizado na `Conta Corrente`.
    * **Polimorfismo:** O método `sacar()` se comporta de forma diferente na `ContaCorrente` (com taxa) e na `ContaPoupanca` (sem taxa).

## 🚀 Conceitos Praticados

Este projeto foi um laboratório para os seguintes conceitos:

* **Programação Orientada a Objetos (POO):**
    * **Abstração:** Uso de classes abstratas (`Conta`) para definir um contrato.
    * **Encapsulamento:** Proteção dos atributos (ex: `saldo`) e acesso via métodos públicos (`depositar()`, `sacar()`).
    * **Herança:** `ContaCorrente` e `ContaPoupanca` herdam da classe `Conta`.
    * **Polimorfismo:** O método `sacar()` é sobrescrito nas classes filhas, tendo comportamentos diferentes (com e sem taxa).
* **Arquitetura MVC (Model-View-Controller):**
    * **`Model`:** A "Cozinha". Camada de dados e regras de negócio (`Cliente`, `Conta`, `Banco`). Não sabe que a `View` existe.
    * **`View`:** O "Salão". Camada de interação com o usuário (`MenuView`). É a única que usa `Scanner` e `System.out.println`.
    * **`Controller`:** O "Garçom". Faz a ponte entre `View` e `Model`, orquestrando as ações.
* **Injeção de Dependência (Manual):**
    * O objeto `Banco` (nossa "Fonte da Verdade" em memória) é criado no `Main` e "injetado" (passado via construtor) para os `Controllers`, que por sua vez são injetados na `View`.

## 📂 Estrutura de Pacotes

O projeto está organizado da seguinte forma: 
/src ├── model/ # A "Cozinha" (Regras de Negócio e Dados) │ ├── Banco.java │ ├── Cliente.java │ ├── Conta.java │ ├── ContaCorrente.java │ └── ContaPoupanca.java │ ├── controller/ # O "Garçom" (Orquestração) │ ├── ClienteController.java │ └── ContaController.java │ └── view/ # O "Salão" (Interação com Usuário) ├── Main.java (Apenas inicializa o sistema) └── MenuView.java (Contém todos os menus e Scanners)
## ☕ Como Executar

1.  Clone este repositório.
2.  Abra o projeto na sua IDE Java favorita (ex: IntelliJ IDEA ou VSCode).
3.  Compile o projeto.
4.  Execute o método `main` da classe `view/Main.java`.
