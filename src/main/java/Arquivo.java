import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    private String path = "C:\\Users\\guilherme\\Documents\\Estudos\\Java\\criar-excel\\criarPlanilha\\src\\main\\java\\matriculas.csv";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Integer> lerArquivo(){
        System.out.println("Lendo arquivo");
        List<Integer> matriculas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linha = br.readLine();

            while(linha != null){
                String[] valoresSeparados = linha.split(";");
                matriculas.add(Integer.parseInt(valoresSeparados[0]));

                linha = br.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matriculas;
    }

    public void escreverArquivo(String nomeArquivo, List<Aluno> matriculas){
        System.out.println("Gerando o arquivo " + nomeArquivo);

        try (var workbook = new HSSFWorkbook();
            var outputStream = new FileOutputStream(nomeArquivo)) {

            var planilha = workbook.createSheet("Pauta de Correcao");
            int numeroDaLinha = 0;

            adicionarCabecalho(planilha, numeroDaLinha++);

            for (Aluno aluno : matriculas){
                var linha = planilha.createRow(numeroDaLinha++);
                adicionarCelula(linha, 0, aluno.getSuaMatricula());
                adicionarCelula(linha, 1, aluno.getMatriculaParaCorrigir());
            }
            workbook.write(outputStream);

        } catch (FileNotFoundException e){
            throw new RuntimeException("Arquivo não encontrado - " + nomeArquivo);
        }
        catch (IOException e) {
            throw new RuntimeException("Erro ao processar o arquivo - " + nomeArquivo);
        }
        System.out.println("Arquivo gerado com sucesso!");
    }

    private void adicionarCabecalho(HSSFSheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelula(linha, 0, "Sua matricula");
        adicionarCelula(linha, 1, "Quem voce corrige");
    }

    private void adicionarCelula(Row linha, int coluna, String valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

    private void adicionarCelula(Row linha, int coluna, int valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

}
