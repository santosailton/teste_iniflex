package org.iniflex;


import org.iniflex.controller.Requisito;
import org.iniflex.factory.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //main com chamada de metodos contendo requisitos do testes.
        //com uso de System.out.println("-".repeat(50)); para facilitar visualização no console os resultados

        // 3.1
        Requisito.adicionarFuncionario(new OperadorFactory(), "Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2000.04));
        Requisito.adicionarFuncionario(new OperadorFactory(), "João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38));
        Requisito.adicionarFuncionario(new CoordenadorFactory(), "Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14));
        Requisito.adicionarFuncionario(new DiretorFactory(), "Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(191198.88));
        Requisito.adicionarFuncionario(new RecepcionistaFactory(), "Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68));
        Requisito.adicionarFuncionario(new OperadorFactory(), "Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72));
        Requisito.adicionarFuncionario(new ContadorFactory(), "Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84));
        Requisito.adicionarFuncionario(new GerenteFactory(), "Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45));
        Requisito.adicionarFuncionario(new EletricistaFactory(), "Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85));
        Requisito.adicionarFuncionario(new GerenteFactory(), "Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93));

        // 3.2
        Requisito.removerFuncionarioPorNome("João");
        // 3.3
        Requisito.exibeFuncionarios();
        System.out.println("-".repeat(50));
        // 3.4
        Requisito.ajustaSalario10PorCento();
        // 3.5
        Requisito.agrupaFuncionario();
        // 3.6
        Requisito.exibeAgrupamento();
        System.out.println("-".repeat(50));
        // 3.8
        Requisito.exibeAniversarioMes10e12();
        System.out.println("-".repeat(50));
        // 3.9
        Requisito.exibeMaisVelho();
        System.out.println("-".repeat(50));
        // 3.10
        Requisito.exibeFuncionariosOrdemAlfabetica();
        System.out.println("-".repeat(50));
        // 3.11
        Requisito.exibeTotalSalario(); //Obs.: salarios com valores reajustados em 10% pela ordem de execução do metodo
        System.out.println("-".repeat(50));
        // 3.12
        Requisito.exibeQtdeSalarioMinimo();
    }
}