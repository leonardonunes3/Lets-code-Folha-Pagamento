package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Programador implements Funcionario {

    private DadosFuncionario dadosFuncionario;

    public Programador(DadosFuncionario dadosFuncionario) {
        setDadosFuncionario(dadosFuncionario);
    }

    @Override
    public void calcularSalario() {
        Date data = new Date();

        if ((data.getMonth() + 1) % 3 == 0) {
            this.dadosFuncionario.setSalario(BigDecimal.valueOf(10000));
        } else {
            this.dadosFuncionario.setSalario(BigDecimal.valueOf(6000));
        }
    }

    @Override
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
        Programador that = (Programador) o;
        return Objects.equals(dadosFuncionario, that.dadosFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dadosFuncionario);
    }
}
