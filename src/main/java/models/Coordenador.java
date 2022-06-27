package models;

import java.math.BigDecimal;

public class Coordenador implements Funcionario {

    private DadosFuncionario dadosFuncionario;

    public Coordenador(DadosFuncionario dadosFuncionario) {
        setDadosFuncionario(dadosFuncionario);
    }

    @Override
    public void calcularSalario() {
        this.dadosFuncionario.setSalario(BigDecimal.valueOf(8000));
    }

    public void setDadosFuncionario(DadosFuncionario dadosFuncionario) {
        this.dadosFuncionario = dadosFuncionario;
    }

    public DadosFuncionario getDadosFuncionario() {
        return dadosFuncionario;
    }
}
