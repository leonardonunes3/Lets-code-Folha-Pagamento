package models;

import java.math.BigDecimal;
import java.util.Objects;

public class GerenteProjetos implements Funcionario {

    private DadosFuncionario dadosFuncionario;

    public GerenteProjetos(DadosFuncionario dadosFuncionario) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GerenteProjetos that = (GerenteProjetos) o;
        return Objects.equals(dadosFuncionario, that.dadosFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dadosFuncionario);
    }
}
