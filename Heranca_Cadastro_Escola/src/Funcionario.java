public class Funcionario extends Pessoa{
    private String setor;
    private float salario;
    private boolean trabalhando = true;

    public void cancelarTrabalhando(){
        this.trabalhando = false;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
