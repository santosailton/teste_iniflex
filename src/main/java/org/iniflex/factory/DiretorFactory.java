package org.iniflex.factory;

import org.iniflex.enums.Funcao;
import org.iniflex.model.Funcionario;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class DiretorFactory implements FuncionarioFactory{
    @Override
    public Funcionario criarFuncionario(String nome, LocalDate dataNascimento, BigDecimal salario) {
        return new Funcionario(nome, dataNascimento, salario, Funcao.DIRETOR.getDescricao());
    }
}
