import java.util.Scanner;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println(" ===Bem vindo ao banco===");
        String tit;
        Conta[]newconta = new Conta[50];

        int opcoes_de_conta;
        int i = 0;
        int senha1;
        int senha2;


        boolean app = true;
        int conta_ou_sem_conta;

        while(app){
            System.out.println("Já possui conta? se sim aperte 1 , se nao aperte 2 e 3 para fechar");
            conta_ou_sem_conta = scanner.nextInt();

            switch(conta_ou_sem_conta){
                case 1:
                    System.out.println("informe o nome do titular da conta:");
                    tit = scanner.nextLine();
                    while(newconta[i] != null){
                        i++;
                    }
                        newconta[i] = new Conta(1000+random.nextInt(9000),10000 + random.nextInt(90000), random.nextInt(9));
                        newconta[i].setTitular(tit);
                        System.out.println("agora digite uma senha numerica:");
                        boolean criar_senha = true;

                        while(criar_senha){
                            senha1 = scanner.nextInt();
                            System.out.println("confirme a senha:");
                            senha2 = scanner.nextInt();
                            if(senha1 == senha2){
                                newconta[i].setSenha(senha1);
                                System.out.println("Conta criada com sucesso!");
                                newconta[i].Dados_Da_Conta();
                                criar_senha = false;
                            }

                        }
                break;

                case 2:
                    System.out.println("Informe o numero da conta:");
                    int verificar_numero = scanner.nextInt();
                    System.out.println("informe a agencia:");
                    int verificar_agencia = scanner.nextInt();
                    System.out.println("informe e o digito:");
                    int verificar_digito = scanner.nextInt();
                    boolean achou_conta = false;
                    int j;
                    for( j = 0 ; !achou_conta || j <50; j++) {
                        if (newconta[j].getNumero() == verificar_numero) {
                            if (newconta[j].getAgencia() == verificar_agencia) {

                                if(newconta[j].getDigito() == verificar_digito){
                                    System.out.println("Infome a senha:");
                                    int verificar_senha = scanner.nextInt();
                                    if(verificar_senha == newconta[j].getsenha()){
                                            achou_conta = true;
                                            System.out.println("Olá " + newconta[j].getTitular());
                                    }
                                    else{
                                        System.out.println("Senha invalida!");
                                        System.out.println("ultima tentativa, Informe a senha ");
                                        verificar_senha = scanner.nextInt();
                                        if (verificar_senha != newconta[j].getsenha()){
                                            System.out.println("Senha invalida , encerrando....");
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if(achou_conta){
                        System.out.println("digite 1 para saque");
                        System.out.println("digite 2 para deposito");
                        System.out.println("digite 3 para ver o saldo");
                        System.out.println("digite 4 para fechar");
                        opcoes_de_conta = scanner.nextInt();
                        while(achou_conta){
                            switch (opcoes_de_conta) {
                                case 1:
                                    System.out.println("valor do saque: ");
                                    int valor_para_saque = scanner.nextInt();
                                    newconta[j].setSaque(valor_para_saque);
                                    break;
                                case 2:
                                    System.out.println("valor do deposito: ");
                                    int valor_do_deposito = scanner.nextInt();
                                    newconta[j].setDepositar(valor_do_deposito);

                                    break;

                                case 3:
                                    newconta[j].getsaldo();
                                    break;

                                case 4:
                                    System.out.println("Encerrando.....");
                                    achou_conta = false;

                                    break;

                                default:
                                    System.out.println("Opção invalida");
                                    break;

                            }
                        }
                    }
                    else{
                        System.out.println("nao foi possivel achar a conta!");
                        System.out.println("conta numero : " + verificar_numero + " agencia: " + "digito: " + verificar_digito + "Não está cadastrada no sistema");
                        System.out.println("Encerrando.....");
                    }
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