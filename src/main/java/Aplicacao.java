import models.DadosFuncionario;
import models.Endereco;
import models.Funcionario;
import models.Programador;
import repository.FuncionarioRepository;

import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        endereco.setCep("73105909");
        endereco.setCidade("Brasilia");
        endereco.setEstado("DF");
        endereco.setComplemento("SQN 315 Bloco C Apt 15");

        DadosFuncionario dadosFuncionario = new DadosFuncionario();
        dadosFuncionario.setCargoFuncionario(DadosFuncionario.CargoFuncionario.PROGRAMADOR);
        dadosFuncionario.setCpf("04839402167");
        dadosFuncionario.setNome("Leonardo");
        dadosFuncionario.setEndereco(endereco);

        Programador leo = new Programador(dadosFuncionario);
        leo.calcularSalario();
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionarioRepository.salvar(leo);
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        listaFuncionarios = funcionarioRepository.recuperarTodos();
        System.out.println(listaFuncionarios.get(0).getDadosFuncionario().toString());

    }

}