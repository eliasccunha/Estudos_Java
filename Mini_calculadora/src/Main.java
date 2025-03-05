
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.println("INICIAR");
        Operacoes.inicio();
     boolean continuar = true;
     while(continuar) {
         System.out.print("informe a operaçao que deseja realizar: ");
         int valor_1, valor_2;
         int escolha = scanner.nextInt();
         int resultado;


         switch (escolha) {
             case 1:
                 System.out.println("--SOMA--");
                 System.out.printf("insira o primeiro valor: ");
                 valor_1 = scanner.nextInt();
                 System.out.printf("insira o segundo valor: ");
                 valor_2 = scanner.nextInt();
                 resultado = Operacoes.somador(valor_1, valor_2);
                 System.out.println("resultado = " +resultado);
                 break;
             case 2:
                 System.out.println("--SUBTRAÇÃO--");
                 System.out.printf("insira o primeiro valor: ");
                 valor_1 = scanner.nextInt();
                 System.out.printf("insira o segundo valor: ");
                 valor_2 = scanner.nextInt();
                 resultado = Operacoes.subtracao(valor_1, valor_2);
                 System.out.println("resultado = " +resultado);
                 break;

             case 3:
                 System.out.println("--MULTIPLICAÇÃO--");
                 System.out.printf("insira o primeiro valor: ");
                 valor_1 = scanner.nextInt();
                 System.out.printf("insira o segundo valor: ");
                 valor_2 = scanner.nextInt();
                 resultado = Operacoes.multiplicador(valor_1, valor_2);
                 System.out.println("resultado = " +resultado);
                 break;
             case 4:
                 System.out.println("--DIVISÃO--");
                 System.out.printf("insira o primeiro valor: ");
                 double dividendo = scanner.nextDouble();
                 System.out.printf("insira o segundo valor: ");
                 double divisor = scanner.nextDouble();
                 double resultado_divisao = Operacoes.divisor(dividendo,divisor);
                 System.out.printf("resultado = %.2f\n", resultado_divisao);
                 break;

             case 5:
                 System.out.println("encerrando programa....");
                 continuar = false;
                 break;
             default:
                 System.out.println("Opçâo invalida");
                 Operacoes.inicio();
                 break;
         }

     }
    }
}