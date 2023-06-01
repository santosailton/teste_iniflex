package org.iniflex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Requisito {

    private Requisito() {
    }

    public static final List<Funcionario> listaFuncionarios = new ArrayList<>();
    public static final Map<String, List<Funcionario>> mapFuncionario = new HashMap<>();

    public static void insereTodosFuncionarios() {
        listaFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2000.04"), Funcao.OPERADOR.getDescricao()));
        listaFuncionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), Funcao.OPERADOR.getDescricao()));
        listaFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), Funcao.COORDENADOR.getDescricao()));
        listaFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("191198.88"), Funcao.DIRETOR.getDescricao()));
        listaFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), Funcao.RECEPCIONISTA.getDescricao()));
        listaFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), Funcao.OPERADOR.getDescricao()));
        listaFuncionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), Funcao.CONTADOR.getDescricao()));
        listaFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), Funcao.GERENTE.getDescricao()));
        listaFuncionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), Funcao.ELETRICISTA.getDescricao()));
        listaFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), Funcao.GERENTE.getDescricao()));

    }

    public static void exibeFuncionarios() {
        listaFuncionarios.forEach(System.out::println);
    }

    public static void removerFuncionarioPorNome(String nome) {
        listaFuncionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));

    }

    public static void ajustaSalario10PorCento() {
        listaFuncionarios.forEach(funcionario -> {
            funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal("1.1")));
        });
    }

    public static void agrupaFuncionario() {

        for(Funcionario funcionario : listaFuncionarios){
            if (mapFuncionario.containsKey(funcionario.getFuncao())) {
                // Se a função já existe no mapa, adiciona o funcionário à lista correspondente
                mapFuncionario.get(funcionario.getFuncao()).add(funcionario);
            } else {
                // Se a função não existe no mapa, cria uma nova lista com o funcionário e adiciona ao mapa
                List<Funcionario> novaLista = new ArrayList<>();
                novaLista.add(funcionario);
                mapFuncionario.put(funcionario.getFuncao(), novaLista);
            }
        }
    }

    public static void exibeAgrupamento() {
        for (Map.Entry<String, List<Funcionario>> entry : mapFuncionario.entrySet()) {
            String chave = entry.getKey();
            List<Funcionario> valor = entry.getValue();
            System.out.println("Chave: " + chave + ", Valor: " + valor);
        }
    }

    public static void exibeAniversarioMes10e12() {
        listaFuncionarios.forEach(funcionario -> {
            int mes = funcionario.getDataNascimento().getMonthValue();
            if((mes == 10) || (mes == 12)){
                System.out.println(funcionario);
            }
        });
    }
    public static void maisVelho(){
        Funcionario funcionarioMaisVelho = null;
        int idadeMaisVelho = 0;
        int idade = 0;
        for (Funcionario funcionario : listaFuncionarios) {
            idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();

            if (idade > idadeMaisVelho) {
                idadeMaisVelho = idade;
                funcionarioMaisVelho = funcionario;
            }
        }
        System.out.println("Nome: "+funcionarioMaisVelho.getNome()+ " Idade: "+idadeMaisVelho+" anos");

    }

    public static void exibeFuncionariosOrdemAlfabetica() {
    }
}
