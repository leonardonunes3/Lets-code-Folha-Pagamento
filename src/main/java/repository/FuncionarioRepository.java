package repository;

import models.Funcionario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class FuncionarioRepository implements Repository<Funcionario> {
    @Override
    public void salvar(Funcionario entity) {
        File arquivo = new File(System.getProperty("user.dir") + "\\folha-pagamento.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Erro ao abrir/criar o arquivo");
        }

        try {
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(entity.getDadosFuncionario().toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados");
        }
    }

    @Override
    public void atualizar(Funcionario entity) {

    }

    @Override
    public void excluir(Funcionario entity) {

    }

    @Override
    public List<Funcionario> recuperarTodos() {
        return null;
    }

    public static BigDecimal buscaSalario(String cpf) {
        return BigDecimal.ZERO;
    }
}
