
public class Main {
    public static void main(String[] args) {
        Arquivo arquivo = new Arquivo();
        var matriculas = arquivo.lerArquivo();
        System.out.println("Lista com todas as matrículas que fizeram a prova " + matriculas);
        System.out.println("A quantidade de alunos foi: " + matriculas.size());

        var matriculasSorteadas = SortiarMatricula.sorteio(matriculas);

        arquivo.escreverArquivo("pauta-correcao.xlsx", matriculasSorteadas);
    }
}
