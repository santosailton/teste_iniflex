package org.iniflex.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa implements Comparable<Funcionario>{
    private BigDecimal salario;
    private String funcao;

    //constutor para criação de funcionario através da instanciação da classe
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento); //uso do super para herdar caracteristicas da classe Pessoa em Funcionario
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    //sobrescrita do metodo toString para retonar objeto contendo funcionario de forma legivel
    // formatação monetária de vírgula para decimal e ponto para milhar com a classe DecimalFormat
    //formatação de data para dd/MM/yyyy com a classe DateTimeFormatter
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,###.00");

        return getNome()
                +"---"+getDataNascimento().format(formato)
                +"---$"+df.format(getSalario())
                +"---"+getFuncao();
    }

    //sobrescrita do metodo compareTo da classe Compareble para definir novo padrão de comparação quando
    //utilizar apenas o Collections.sort(lista) para fazer uma ordenação
    //o metodo retorna um valores negativo, positivo ou zero caso seja alfabeticamente menor, maior ou igual ao objeto do parametro
    @Override
    public int compareTo(Funcionario funcionario) {
        return this.getNome().compareTo(funcionario.getNome());
    }

}
