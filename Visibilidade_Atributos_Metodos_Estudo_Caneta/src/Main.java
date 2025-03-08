//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean programa = true;
        Caneta c1 = new Caneta("Bic", "Azul",0.5f);
        c1.tampada = false;
        c1.carga = 20;
        Caneta c2 = new Caneta("Micron", "Preta", 0.9f);
        c2.tampada = true;
        c2.carga = 3;

        while(programa) {
            System.out.println("escolha a caneta que quer usar a opção 1 ou  2");
            System.out.println("para o status das canetas digite 3");
            System.out.println("para fechar digite 4");
            int caneta = scanner.nextInt();
            switch (caneta) {
                case 1:
                    c1.rabisca();
                    break;
                case 2:
                    c2.rabisca();
                    break;
                case 3:
                    System.out.println("Caneta 1");
                    c1.status();
                    System.out.println("Caneta 2");
                    c2.status();
                    break;
                case 4:
                    System.out.println("Encerrando o programa....");
                    programa = false;
            }
        }

    }
}
