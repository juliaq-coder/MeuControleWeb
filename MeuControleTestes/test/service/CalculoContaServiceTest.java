/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package service;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author julia
 */
public class CalculoContaServiceTest {
    
    @Test
    public void deveCalcularValorRestanteCorretamente() {
        CalculoContaService service = new CalculoContaService();

        double resultado =
                service.calcularValorRestante(237.00, 100.00);

        assertEquals(137.00, resultado, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarPagamentoNegativo() {
        CalculoContaService service = new CalculoContaService();

        service.calcularValorRestante(237.00, -10.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarPagamentoMaiorQueValorDaConta() {
        CalculoContaService service = new CalculoContaService();

        service.calcularValorRestante(100.00, 150.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarValorDaContaIgualAZero() {
        CalculoContaService service = new CalculoContaService();

        service.calcularValorRestante(0.00, 0.00);
    }

    @Test
    public void pagamentoTotalDeveDeixarValorRestanteZero() {
        CalculoContaService service = new CalculoContaService();

        double resultado =
                service.calcularValorRestante(200.00, 200.00);

        assertEquals(0.00, resultado, 0.001);
    }
}
