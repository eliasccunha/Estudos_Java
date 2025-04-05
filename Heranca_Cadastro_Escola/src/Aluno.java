public class Aluno extends  Pessoa{
    private  boolean matricula = true;
    private String curso = null;

    public void cancelarMatricula(){
        this.matricula = false;
    }

    public boolean getMatricula() {
        return matricula;
    }

    public void setMatricula() {
        this.matricula = true;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
