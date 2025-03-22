import java.util.Random;

public class Livro implements  Publicacao {
    String titulo;
    String autor;
    int totaldepaginas;
    int paginaatual;
    boolean aberto;
    Pessoa dono;


    public  Livro(String titulo, String autor, int totaldepaginas){
        this.titulo = titulo;
        this.autor = autor;
        this.totaldepaginas = totaldepaginas;
        this.paginaatual = 0;
        this.aberto = false;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotaldepaginas() {
        return totaldepaginas;
    }

    public void setTotaldepaginas(int totaldepaginas) {
        this.totaldepaginas = totaldepaginas;
    }

    public int getPaginaatual() {
        return paginaatual;
    }

    public void setPaginaatual(int paginaatual) {
        this.paginaatual = paginaatual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public void detalhes(){
        System.out.println("Autor: " + this.autor);
        System.out.println("Titulo: "+ this.titulo);
        System.out.println("Total de paginas: "+ this.totaldepaginas);
        System.out.println("Livro pertence atualmente a " + this.dono.getNome());
    }

    @Override
    public void abrir() {
        this.aberto = true;
    }

    @Override
    public void fechar() {
        this.aberto = false;
    }

    @Override
    public void folhear() {
        Random random = new Random();
        this.setPaginaatual(+random.nextInt(this.totaldepaginas));
    }

    @Override
    public void avancarpag() {
        if(this.paginaatual > this.totaldepaginas) {
            this.setPaginaatual(+1);
        }
        else{
            System.out.println("O livro esta na pagina final!");
        }
    }

    @Override
    public void voltarpag() {
        if(this.paginaatual < 2){
            this.setPaginaatual(-1);
        }
        else{
            System.out.println("Já está na primeira pagina");
        }
    }
}
