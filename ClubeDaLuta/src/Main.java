import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Campeonato de Porradarias");
        System.out.println("Quantos lutadores vão participar?");
        int participantes = scanner.nextInt();


        Lutador[]lutadores = new Lutador[participantes];
        for(int i = 0 ; i < participantes;i++) {
            scanner.nextLine();
            System.out.print("Informe o nome do lutador: ");
            String cadastronome = scanner.nextLine();

            System.out.print("Nacionalidade: ");
            String cadastronacionalidade = scanner.nextLine();


            System.out.print("Idade: ");
            int cadastroidade = scanner.nextInt();

            System.out.print("Altura: ");
            double cadastroaltura = scanner.nextDouble();

            System.out.print("Peso: ");
            double cadastropeso = scanner.nextDouble();


            lutadores[i] = new Lutador(cadastronome, cadastronacionalidade, cadastroidade, cadastroaltura, cadastropeso);

        }
            Luta lutas = new Luta();



            for(int j = 0 ; j < participantes / 2; j++){
                int t = 0;
                lutas.marcarLuta(lutadores[t], lutadores[t + 1]);
                lutas.lutar(lutadores[t], lutadores[t + 1]);
            }

            for(int i = 0 ; i < participantes / 2; i++){
                lutadores[i].apresentar();
                lutadores[i].statusLutador();
                System.out.println();
                lutadores[i + 1].apresentar();
                lutadores[i + 1].statusLutador();
            }


    }
}