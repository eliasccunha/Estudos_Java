
public class Pessoa {
    private String nome;
    private String sexo;
    private int idade;

    public Pessoa(String nome , String sexo, int idade){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void fazerAniversario(){
        this.idade++;
    }

}

