/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author julia
 */
public class CalculoContaService {
    
    public double calcularValorRestante(
            double valorConta,
            double valorPago) {

        if (valorConta <= 0) {
            throw new IllegalArgumentException(
                    "O valor da conta deve ser maior que zero.");
        }

        if (valorPago < 0) {
            throw new IllegalArgumentException(
                    "O valor pago não pode ser negativo.");
        }

        if (valorPago > valorConta) {
            throw new IllegalArgumentException(
                    "O valor pago não pode ser maior que o valor da conta.");
        }

        return valorConta - valorPago;
    }
}
