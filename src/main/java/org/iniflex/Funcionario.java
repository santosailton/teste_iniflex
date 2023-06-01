package org.iniflex;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Funcionario extends Pessoa implements Comparator {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {
        super();
    }

    @Override
    public int compareTo(Funcionario funcionario, Funcionario funcionario2) {
        return 0;
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

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,###.00");

        return getNome()
                +" "+getDataNascimento().format(formato)
                +" "+df.format(getSalario())
                +" "+getFuncao();
    }

    @Override
    public int compare(Funcionario funcionario, Funcionario funcionario2) {
        return funcionario.getNome().compareTo(funcionario2.getNome());
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
