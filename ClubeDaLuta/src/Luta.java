
import java.util.Random;

public class Luta{
    public Lutador desafiado;
    public Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public void marcarLuta(Lutador l1, Lutador l2){


        if(l1.getCategoria().equals(l2.getCategoria())){
            this.aprovada = true;
            this.desafiado = l1;
            this.desafiante = l2;

        }else{
            this.aprovada = false;
            this.desafiado = l1;
            this.desafiante = l2;
            System.out.println("categorias diferentes");
        }
    }

    public void lutar(Lutador desafiante, Lutador desafiado){
            if(this.aprovada){
                System.out.println("###DESAFIANTE###");
                this.desafiante.getNome();
                System.out.println("###DESAFIADO");
                this.desafiado.getNome();
                Random random = new Random();
                int random1 = random.nextInt();
                int random2 = random.nextInt();

                if(random1 == random2){
                    System.out.println("EMPATE!!!");
                    this.desafiante.setEmpate(+ 1);
                    this.desafiado.setEmpate(+ 1);
                }
                else if( random1 > random2){
                    System.out.println("Desafiante Ganhou!");
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();

                }
                else {
                    System.out.println("Vitoria do desafiado");
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                }
            }
            else{
                System.out.println("Luta nao aprovada!");
            }

    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
}
