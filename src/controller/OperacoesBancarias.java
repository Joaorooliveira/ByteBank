package controller;

import model.ContaCorrente;

public interface OperacoesBancarias {

    public void depositar(double saldo);
    public void sacar(double saldo);

}
