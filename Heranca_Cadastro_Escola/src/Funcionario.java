public class Funcionario extends Pessoa{
    private String setor = null;
    private float salario = 0;
    private boolean trabalhando = true;

    public void cancelarTrabalhando(){
        this.trabalhando = false;
    }

    public void statusTrabalho(){
        if(this.trabalhando){
            System.out.println("Funcionario faz parte do quadro de funcionarios");
        }
        else{
            System.out.println("Funcionario não faz parte do quadro de funcionarios");
        }
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
