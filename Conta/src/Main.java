import java.util.Scanner;
import java.util.Random;

public class Main {
   static String tit;
   static boolean app = true;
   static int senha1;
   static int senha2;
   static boolean criar_senha = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println(" ===Bem vindo ao banco===");
        while(app){

            System.out.println("Já possui conta? se sim aperte 1 , se nao aperte 2 e 3 para fechar");
            int conta_ou_sem_conta;
            conta_ou_sem_conta = scanner.nextInt();
            switch(conta_ou_sem_conta){
                case 1:
                    System.out.println("informe o nome do titular da conta:");
                    tit = scanner.nextLine();
                    Conta newconta = new Conta(1000+random.nextInt(9000),10000 + random.nextInt(90000), random.nextInt(9));
                    newconta.setTitular(tit);
                    System.out.println("agora digite uma senha numerica:");
                    while(criar_senha){
                        senha1 = scanner.nextInt();
                        System.out.println("confirme a senha:");
                        if(senha1 == senha2){
                            newconta.setSenha(senha1);
                        }
                        System.out.println("Conta criada com sucesso!");
                        newconta.Dados_Da_Conta();
                    }

                break;

                case 2:

                    break;
                case 3:
                    app = false;
                break;

                default:
                    System.out.println("Opção invalida");
                    break;
            }


        }

    }
}