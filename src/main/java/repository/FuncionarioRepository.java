package repository;

import models.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

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
    //TO-DO: Implementação atualização do registro
    }

    @Override
    public void excluir(Funcionario entity) {
    //TO-DO: Implementação da exclusão do registro
    }

    @Override
    public ArrayList<Funcionario> recuperarTodos() {
        File arquivo = new File(System.getProperty("user.dir") + "\\folha-pagamento.txt");
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

        if (!arquivo.exists()) {
            System.out.println("Não existe arquivo com lista de funcionarios");
        } else {
            try {
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr);
                while (br.ready()) {
                    String linha = br.readLine();
                    try (Scanner tokens = new Scanner(linha)) {
                        tokens.useDelimiter(",");

                        int contador = 0;
                        DadosFuncionario dadosFuncionario = new DadosFuncionario();
                        Endereco endereco = new Endereco();
                        String cargo = "";

                        while(tokens.hasNext()) {
                            switch(contador) {
                                case 0:
                                    cargo = tokens.next();
                                    break;
                                case 1:
                                    dadosFuncionario.setNome(tokens.next());
                                    break;
                                case 2:
                                    dadosFuncionario.setCpf(tokens.next());
                                    break;
                                case 3:
                                    endereco.setCidade(tokens.next());
                                    break;
                                case 4:
                                    endereco.setEstado(tokens.next());
                                    break;
                                case 5:
                                    endereco.setCep(tokens.next());
                                    break;
                                case 6:
                                    endereco.setComplemento(tokens.next());
                                    break;
                                case 7:
                                    dadosFuncionario.setSalario(BigDecimal.valueOf(Integer.parseInt(tokens.next())));
                                    break;
                            }
                            contador++;
                        }
                        dadosFuncionario.setEndereco(endereco);
                        switch(cargo) {
                            case "PROGRAMADOR":
                                dadosFuncionario.setCargoFuncionario(DadosFuncionario.CargoFuncionario.PROGRAMADOR);
                                Programador programador = new Programador(dadosFuncionario);
                                listaFuncionarios.add(programador);
                                break;
                            case "COORDENADOR":
                                dadosFuncionario.setCargoFuncionario(DadosFuncionario.CargoFuncionario.COORDENADOR);
                                Coordenador coordenador = new Coordenador(dadosFuncionario);
                                listaFuncionarios.add(coordenador);
                                break;
                            case "GERENTE_PROJETOS":
                                dadosFuncionario.setCargoFuncionario(DadosFuncionario.CargoFuncionario.GERENTE_PROJETOS);
                                GerenteProjetos gerenteProjetos = new GerenteProjetos(dadosFuncionario);
                                listaFuncionarios.add(gerenteProjetos);
                                break;
                        }
                    }
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo");
            }
        }

        return listaFuncionarios;
    }

    public BigDecimal buscaSalario(String cpf, ArrayList<Funcionario> listaFuncionarios) {

        for (Funcionario funcionario : listaFuncionarios) {
            if(funcionario.getDadosFuncionario().getCpf().equals(cpf)) {
                return funcionario.getDadosFuncionario().getSalario();
            }
        }

        return BigDecimal.valueOf(-1);
    }

    public void listaSalarios(ArrayList<Funcionario> listaFuncionarios) {
        BigDecimal totalSalarios = BigDecimal.ZERO;

        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario.getDadosFuncionario().toString());
            totalSalarios = totalSalarios.add(funcionario.getDadosFuncionario().getSalario());
        }
        System.out.println("Total dos salários é: " + totalSalarios);
    }
}
