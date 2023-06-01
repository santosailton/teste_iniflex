package org.iniflex;


import org.iniflex.controller.Requisito;

public class Main {
    public static void main(String[] args) {
        //main com chamada de metodos contendo requisitos do testes.
        //com uso de System.out.println("-".repeat(50)); para facilitar visualização no console os resultados

        // 3.1
        Requisito.insereTodosFuncionarios();
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