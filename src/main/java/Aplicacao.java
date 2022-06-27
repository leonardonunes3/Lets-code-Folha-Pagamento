import models.DadosFuncionario;
import models.Endereco;
import models.Programador;
import repository.FuncionarioRepository;

import java.io.*;

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


    }



    public static void escreverLerArquivoTxt () {
        File arquivo = new File(System.getProperty("user.dir") + "\\folha-pagamento.txt");
        try {
            if (!arquivo.exists()) {
                //cria um arquivo (vazio)
                arquivo.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("ERRO ARQUIVO");
        }

        //escreve no arquivo
        try {
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Texto a ser escrito no txt3");
            bw.newLine();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Erro ao abrir arquivo");
        }

        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            //enquanto houver mais linhas
            while (br.ready()) {
                //lê a proxima linha
                String linha = br.readLine();
                //faz algo com a linha
                System.out.println(linha);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
        }
    }
}