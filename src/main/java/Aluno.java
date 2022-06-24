public class Aluno {

    private int suaMatricula;
    private int matriculaParaCorrigir;

    public Aluno(int suaMatricula, int matriculaParaCorrigir) {
        this.suaMatricula = suaMatricula;
        this.matriculaParaCorrigir = matriculaParaCorrigir;
    }

    public int getSuaMatricula() {
        return suaMatricula;
    }

    public void setSuaMatricula(int suaMatricula) {
        this.suaMatricula = suaMatricula;
    }

    public int getMatriculaParaCorrigir() {
        return matriculaParaCorrigir;
    }

    public void setMatriculaParaCorrigir(int matriculaParaCorrigir) {
        this.matriculaParaCorrigir = matriculaParaCorrigir;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "suaMatricula=" + suaMatricula +
                ", matriculaParaCorrigir=" + matriculaParaCorrigir +
                '}';
    }
}
