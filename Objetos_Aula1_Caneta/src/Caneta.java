import java.util.Scanner;

public class Caneta {

    Scanner scanner = new Scanner(System.in);
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;

    void status(){
        System.out.println("Modelo "+ this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta "+ this.ponta);
        System.out.println("Carga " + this.carga +"%");
        System.out.println("Está tampada? "+ this.tampada);

    }

    void rabisca(){
        if(carga > 0){

            if (this.tampada == true){
                System.out.println("a caneta esta tampada");
                System.out.println("Deseja Destamapar? Sim ou nao? (S/N)");
                char destampar_caneta_resposta = scanner.next().charAt(0);
                if(destampar_caneta_resposta == 'S') {
                    this.tampada = true;
                    System.out.println("rabiscos  " + this.cor + " da caneta " + this.modelo + " com a ponta " + this.ponta);
                    this.carga--;
                }
            }
            else{
                System.out.println("Não da pra rabiscar com a caneta tampada!");
            }
        }
        else{
            System.out.println("Caneta sem carga");
        }
    }

    void tampar(){
        this.tampada = true;
    }
    void destampar(){
        this.tampada = false;
    }
}
