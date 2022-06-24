import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortiarMatricula {

    private static List<Integer> embaralhaLista(List<Integer> lista){
        Random gerador = new Random();
        List<Integer> novaLista = new ArrayList<>();
        while(!lista.isEmpty()){
            int tamanhoLista = lista.size();
            int posicao = gerador.nextInt(tamanhoLista);
            var elementoRemovido = lista.remove(posicao);
            novaLista.add(elementoRemovido);
        }
        return novaLista;
    }

    public static List<Aluno> sorteio(List<Integer> listaComMatriculas){
        System.out.println("Sorteando as matrículas");
        var novaLista = embaralhaLista(listaComMatriculas);
        List<Aluno> matriculaSorteada = new ArrayList<>();

        for(int i = 0; i < novaLista.size();i++){
            if (i == novaLista.size() - 1) {
                matriculaSorteada.add(new Aluno(novaLista.get(i), novaLista.get(0)));
                break;
            }
            matriculaSorteada.add(new Aluno(novaLista.get(i), novaLista.get(i + 1)));
        }
        System.out.println("Matriculas sorteadas com sucesso!");
        return matriculaSorteada;
    }

}
