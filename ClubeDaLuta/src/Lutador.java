public class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private double altura;
    private double peso;
    private String categoria;
    private int derrotas;
    private int  vitorias;
    private int empate;


    public Lutador(String nome, String nacionalidade, int idade, double altura, double peso){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.setCategoria(peso);
        this.derrotas = 0;
        this.vitorias = 0;
        this.empate = 0;
    }


    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(double peso) {
        if(peso < 70f){
            this.categoria = "leve";
        }
        else if(peso > 70f && peso <= 83f){
            this.categoria = "medio";
        }
        else if(peso > 83f && peso <= 110f){
            this.categoria = "pesado";
        }
        else{
            this.categoria = "invalido";
        }
    }

    public int getDerrotas() {
        return this.derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getVitorias() {
        return this.vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getEmpate() {
        return this.empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }

    ///  metodos
    public void apresentar(){
        System.out.println("O " + this.getNome() + " nacionalidade " + this.getNacionalidade());
        System.out.println("Ele tem " + this.getAltura() + " de altura com " + this.getPeso() + "kilos e com " + this.getIdade() + " anos ele luta na categoria " + this.getCategoria());

    }

    public void ganharLuta(){
        this.setVitorias(this.getVitorias() + 1);
    }

    public void empatarLuta(){
        this.setEmpate(this.getEmpate() + 1);
    }

    public void perderLuta(){
        this.setDerrotas(this.getDerrotas() + 1);
    }

    public void statusLutador(){


        System.out.printf(" vitorias %d \n", this.getVitorias());
        System.out.printf(" Derrotas %d \n", this.getDerrotas());
        System.out.printf(" Empates  %d \n", this.getEmpate());


    }


}
