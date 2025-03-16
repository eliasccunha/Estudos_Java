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


    public Lutador(String nome, String nacionalidade, int idade, double altura, double peso, int derrotas, int vitorias, int empate){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.setCategoria(peso);
        this.derrotas = derrotas;
        this.vitorias = vitorias;
        this.empate = empate;
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
        if(peso <= 70 && peso >= 65){
            this.categoria = "leve";
        }
        else if(peso > 70 && peso <= 83){
            this.categoria = "medio";
        }
        else if(peso > 83 && peso <= 110){
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
    private void Apresentar(){
        System.out.println("O " + this.getNome() + " nacionalidade " + this.getNacionalidade()  + "com " +this.getVitorias()
                + "vitorias, "+ this.getDerrotas() + "derrotas e " + this.getEmpate() + "empates " );
        System.out.println("Ele tem " + this.getAltura() + " de altura com " + this.getPeso() + "kilos e com " + this.getIdade() + " anos ele luta na categoria " + this.getCategoria());

    }

    private void ganharLuta(){
        this.setVitorias(this.getVitorias() + 1);
    }

    private void empatarLuta(){
        this.setEmpate(this.getEmpate() + 1);
    }

    private void perderLuta(){
        this.setDerrotas(this.getDerrotas() + 1);
    }

    private void statusLutador(){
        int totaldelutas = this.getDerrotas() + this.getEmpate() + this.getVitorias();

        double taxadevitorias = (totaldelutas / (double)this.getVitorias()) * 100;
        double taxadederrotas = (totaldelutas / (double)this.getDerrotas()) * 100;
        double taxadeempates = (totaldelutas / (double)this.getEmpate()) * 100;

        System.out.printf("Taxa de vitorias %.1f, com %d vitorias\n", taxadevitorias, this.getVitorias());
        System.out.printf("Taxa de derrotas %.1f, com %d derrotas\n", taxadederrotas, this.getDerrotas());
        System.out.printf("Taxa de empates %.1f, com %d empates\n", taxadeempates, this.getEmpate());


    }

}
