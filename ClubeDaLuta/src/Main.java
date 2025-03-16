import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}import java.util.Scanner;

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

            System.out.print("Derrotas: ");
            int cadastroderrotas = scanner.nextInt();

            System.out.print("Vitorias: ");
            int cadastrovitorias = scanner.nextInt();

            System.out.print("Empates: ");
            int cadastroempates = scanner.nextInt();

            lutadores[i] = new Lutador(cadastronome, cadastronacionalidade, cadastroidade, cadastroaltura, cadastropeso, cadastroderrotas, cadastrovitorias, cadastroempates);

        }
        boolean temporada = true;

        while(temporada){





        }
    }
}