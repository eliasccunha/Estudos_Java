import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        boolean programa = true;
        Caneta c1 = new Caneta();
        c1.modelo = "Bic";
        c1.cor = "Azul";
        c1.ponta = 0.5f;
        c1.tampada = false;
        c1.carga = 20;


        Caneta c2 = new Caneta();
        c2.modelo = "Micron";
        c2.cor = "Preta";
        c2.ponta = 0.8f;
        c2.tampada = true;
        c2.carga = 3;


        while(programa){


           System.out.println("escolha a caneta que quer usar a opção 1 ou  2");
           System.out.println("para o status das canetas digite 3");
           System.out.println("para fechar digite 4");
           int caneta = scanner.nextInt();


           switch (caneta) {
               case 1:
                   System.out.println("sera apenas rabiscos, nao sei escrever =/");
                   c1.rabisca();
                   System.out.println("escolha a caneta que quer usar a opção 1 ou  2");
                   break;
               case 2:
                   System.out.println("sera apenas rabiscos, nao sei escrever =/");
                   c2.rabisca();

                   break;
               case 3:
                   System.out.println("Caneta 1");
                   c1.status();
                   System.out.println("Caneta 2");
                   c2.status();

                   break;
               case 4:
                   programa = false;

           }

       }
    }
}