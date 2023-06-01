package org.iniflex.controller;

import org.iniflex.enums.Funcao;
import org.iniflex.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Requisito {

    // variváveis de escopo global para serem usadas facilmente em toda a classe
    public static final List<Funcionario> listaFuncionarios = new ArrayList<>();
    public static final Map<String, List<Funcionario>> mapFuncionario = new HashMap<>();

    // definição do construtor como privado apenas por conta do uso dos todos metodos serem estaticos
    private Requisito() {
    }
    
    public static void insereTodosFuncionarios() {
        // inserção de funcionarios com adicional para uso da constante de ENUM para função
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
        System.out.println("3.3 - Exibindo todos inseridos");
        // exibição de funcionarios com uso de forEach
        listaFuncionarios.stream().forEach(System.out::println);
    }

    public static void removerFuncionarioPorNome(String nome) {
        // uso do método removeIf da função lambda para executar instrução da sequencia caso nomes iguais
        listaFuncionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));

    }

    public static void ajustaSalario10PorCento() {
        // uso da função lambda para realizar aplicação de 10% em cada salario de funcionario
        // multiplicando com o método multiply da classe BigDecimal a adição de 10% (salario x 1.1)
        listaFuncionarios.stream()
                .forEach(funcionario ->
            funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal("1.1")))
        );
    }

    public static void agrupaFuncionario() {
        // loop com lambda para tratar FUNCAO existentes e FUNCAO que podem ser incluidas no projeto como CEO, Analista, etc
        listaFuncionarios.stream().forEach(funcionario -> {
            if (mapFuncionario.containsKey(funcionario.getFuncao())) {
                // Se a FUNCAO já existe no map, adiciona o funcionário à lista da FUNCAO correspondente
                mapFuncionario.get(funcionario.getFuncao()).add(funcionario);
            } else {
                // Se a FUNCAO não existe no map, cria uma nova lista com o funcionário e adiciona ao map
                List<Funcionario> novaLista = new ArrayList<>();
                novaLista.add(funcionario);
                mapFuncionario.put(funcionario.getFuncao(), novaLista);
            }
        });
    }

    public static void exibeAgrupamento() {
        System.out.println("3.6 - Exibindo agrupamento ");
        // loop com lambda  para exibir agrupamento com FUNCAO e lista de FUNCIONARIOS contidos em cada FUNCAO
        mapFuncionario.entrySet().stream().forEach(item ->{
            String funcao = item.getKey(); // recupera a FUNCAO (chave)
            List<Funcionario> funcionario = item.getValue();// recupera so FUNCIONARIOS (valor)
            System.out.println("FUNÇÃO: " + funcao + ", FUNCIONARIOS: " + funcionario);
        });
    }

    public static void exibeAniversarioMes10e12() {
        System.out.println("3.8 - Exibindo aniversariantes do mes 10 e 12");
        // loop lambda para validar se o mes dos funcionários corresponde à
        // condição de mes 10 ou 12 extraido pelo getMonthValue()
        listaFuncionarios.stream().forEach(funcionario -> {
            int mes = funcionario.getDataNascimento().getMonthValue();
            if((mes == 10) || (mes == 12)){
                System.out.println(funcionario);
            }
        });
    }
    
    public static void exibeMaisVelho(){
        Funcionario funcionarioMaisVelho = null;
        int idadeMaisVelho = 0;
        int idade = 0;
        System.out.println("3.9 - Exibindo mais velho ");

        // for loop para calcular idade dos funcionarios, irá atribuir em idadeMaisVelho a idade maior encontrada
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
        System.out.println("3.10 - Exibindo ordem alfabética ");
        // ordenando com implementação de Comparable na classe Funcionario como tipo padrão de ordenação por nome
        // definido no método compareTo da classe Funcionario
        Collections.sort(listaFuncionarios);
        // função lambda para exibir funcionarios ordenados por nome
        listaFuncionarios.stream().forEach(funcionario -> System.out.println(funcionario.getNome()));
    }

    public static void exibeTotalSalario() {
        BigDecimal totalSalario = BigDecimal.ZERO;
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("3.11 - Exibindo salário total de todos funcionários");
        // acumulando salarios de funcionarios na variavel totalSalario através do metodo add de BigDecimal
        // uso da mascara "#,###.00" para definir separação de milhar e decimal na saida de dados
        for(Funcionario funcionario : listaFuncionarios){
            totalSalario = totalSalario.add(funcionario.getSalario());
        }
        System.out.println("Total: "+df.format(totalSalario));
    }

    public static void exibeQtdeSalarioMinimo() {
        String divisor = "1212";
        System.out.println("3.12 - Exibindo quantidade de salários minimos por funcionário ");

        // loop lambda para percorrer salarios e dividir pelo valor de salário minimo definido na variavel "divisor"
        // e assim descobrindo quantos salarios minimos contem cada funcionario
        // o resultado retorna um decimal, para reduzir a quantidade de decimais foi usado o parametro 2
        // e com arredondamento para cima da 2a casa decimal se valores >= 5 da 3a casa decimal
        // ou para baixo se <= 5 da terceira casa decimal
        listaFuncionarios.stream().forEach(funcionario -> {
            BigDecimal res = funcionario.getSalario().divide(new BigDecimal(divisor), 2 , RoundingMode.HALF_UP);
            System.out.println("Nome: "+funcionario.getNome()+" ||"+"Salarios min: "+ res);
        });
    }
}
