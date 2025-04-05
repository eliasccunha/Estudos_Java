public class Professor extends  Pessoa{
    private String especialidade = null;
    private float salario = 0;



    public void receberAumento(float aumento){
        this.setSalario(getSalario() + aumento);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
