import models.*;
import repository.FuncionarioRepository;

import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args) {

        Endereco endereco1 = new Endereco();
        endereco1.setCep("73105909");
        endereco1.setCidade("Brasilia");
        endereco1.setEstado("DF");
        endereco1.setComplemento("SQN 315 Bloco C Apt 15");

        DadosFuncionario dadosFuncionario1 = new DadosFuncionario();
        dadosFuncionario1.setCargoFuncionario(DadosFuncionario.CargoFuncionario.PROGRAMADOR);
        dadosFuncionario1.setCpf("97694973048");
        dadosFuncionario1.setNome("Leonardo");
        dadosFuncionario1.setEndereco(endereco1);

        Programador programador = new Programador(dadosFuncionario1);
        programador.calcularSalario();

        Endereco endereco2 = new Endereco();
        endereco2.setCep("72104947");
        endereco2.setCidade("Brasilia");
        endereco2.setEstado("DF");
        endereco2.setComplemento("SQN 716 Bloco A Apt 1");

        DadosFuncionario dadosFuncionario2 = new DadosFuncionario();
        dadosFuncionario2.setCargoFuncionario(DadosFuncionario.CargoFuncionario.COORDENADOR);
        dadosFuncionario2.setCpf("12813363006");
        dadosFuncionario2.setNome("Marcos");
        dadosFuncionario2.setEndereco(endereco2);

        Coordenador coordenador = new Coordenador(dadosFuncionario2);
        coordenador.calcularSalario();

        Endereco endereco3 = new Endereco();
        endereco3.setCep("72103697");
        endereco3.setCidade("Brasilia");
        endereco3.setEstado("DF");
        endereco3.setComplemento("SQN 105 Bloco G Apt 26");

        DadosFuncionario dadosFuncionario3 = new DadosFuncionario();
        dadosFuncionario3.setCargoFuncionario(DadosFuncionario.CargoFuncionario.GERENTE_PROJETOS);
        dadosFuncionario3.setCpf("65523811823");
        dadosFuncionario3.setNome("Roberto");
        dadosFuncionario3.setEndereco(endereco3);

        GerenteProjetos gerenteProjetos = new GerenteProjetos(dadosFuncionario3);
        gerenteProjetos.calcularSalario();

        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionarioRepository.salvar(programador);
        funcionarioRepository.salvar(coordenador);
        funcionarioRepository.salvar(gerenteProjetos);

        ArrayList<Funcionario> listaFuncionarios = funcionarioRepository.recuperarTodos();
        funcionarioRepository.listaSalarios(listaFuncionarios);
        System.out.println(funcionarioRepository.buscaSalario("12813363006", listaFuncionarios));

    }

}