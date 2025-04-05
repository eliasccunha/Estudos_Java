public abstract class Pessoa {
    private String nome = "nada";
    private int idade = 0 ;
    private  String sexo = null;



    public void fazerAniversario (){
        this.idade++;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void informacoesBasica(){
        System.out.println("Nome: " + this.getNome());
        System.out.println("sexo: " + this.getSexo() + ", idade: " + this.getIdade());
    }

}
