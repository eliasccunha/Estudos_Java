import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Professor[]professores = new Professor[50];
        Aluno[]alunos = new Aluno[50];
        Funcionario[] funcionarios = new Funcionario[50];

        boolean ativo = true;
        int i = 0, j = 0, p = 0;

        while(ativo){
            System.out.println("informe o cadastro a ser feito");
            System.out.println("digite 1 para professor, 2 para aluno , 3 para funcionario");
            System.out.println("para alterar dados cadastrado digite 4 e para fechar 5");
            int escolha = scanner.nextInt();
            int idade;
            String nome;
            String sexo;
            scanner.nextLine(); /// limpar buffer

            switch (escolha){
                case 1:
                    if(i < 50) {
                        System.out.println("=== cadastro professor ===");
                        System.out.println("infome o nome do professor :");
                        nome = scanner.nextLine();
                        System.out.println("sexo: ");
                        sexo = scanner.nextLine();
                        System.out.println("qual a especialidade: ");
                        String especilidade = scanner.nextLine();
                        System.out.println("idade: ");
                        idade = scanner.nextInt();
                        System.out.println("informe o salario: ");
                        float salario = scanner.nextFloat();
                        scanner.nextLine(); /// limpar buffer

                        professores[i].setNome(nome);
                        professores[i].setSexo(sexo);
                        professores[i].setEspecialidade(especilidade);
                        professores[i].setIdade(idade);
                        professores[i].setSalario(salario);
                        i++;
                        System.out.println("professor cadastrado!");
                    }
                    else{
                        System.out.println("Nao temos vagas para novos professores");
                    }
                    break;

                case 2:
                    if(j < 1000){
                        System.out.println("=== cadastro Aluno ===");
                        System.out.println("informe o nome do aluno: ");
                        nome = scanner.nextLine();
                        System.out.println("sexo: ");
                        sexo = scanner.nextLine();
                        System.out.println("qual curso: ");
                        String curso = scanner.nextLine();
                        System.out.println("idade: ");
                        idade = scanner.nextInt();
                        scanner.nextLine(); /// limpar buffer

                        alunos[j].setNome(nome);
                        alunos[j].setSexo(sexo);
                        alunos[j].setCurso(curso);
                        alunos[j].setIdade(idade);
                        alunos[j].setMatricula();
                        System.out.println("aluno matriculado!");
                        j++;
                    }
                    else{
                        System.out.println("não temos vagas para novas matriculas");
                    }
                    break;

                case 3:
                    if(p < 20){
                        System.out.println("=== cadastro funcionario ===");
                        System.out.println("informe o nome do funcionario: ");
                        nome = scanner.nextLine();
                        System.out.println("sexo: ");
                        sexo = scanner.nextLine();
                        System.out.println("qual o setor: ");
                        String setor = scanner.nextLine();
                        System.out.println("qual a idade: ");
                        idade = scanner.nextInt();
                        System.out.println("salario: ");
                        scanner.nextLine(); /// limpar o buffer

                        float salario = scanner.nextFloat();
                        funcionarios[p].setNome(nome);
                        funcionarios[p].setSexo(sexo);
                        funcionarios[p].setSetor(setor);
                        funcionarios[p].setIdade(idade);
                        funcionarios[p].setSalario(salario);
                        p++;
                        System.out.println("funcionario cadastrado!!");
                    }
                    else{
                        System.out.println("sem vagas nos momento");
                    }
                    break;

                case 4 :
                    boolean dados = true;
                    while(dados){
                        System.out.println("informe os dados que precisa verificar");
                        System.out.println("digite 1 para professor, 2 para aluno , 3 para funcionario");
                        int cadastro = scanner.nextInt();
                        scanner.nextLine(); /// limpar o buffer

                        switch (cadastro){
                            case 1:
                                System.out.println("informe o nome do aluno: ");
                                nome = scanner.nextLine();
                                boolean naoachou = true;
                                int x;
                                for(x = 0 ; x < 1000 ; x++){
                                    if(alunos[x].getNome().equals(nome)){
                                            naoachou = false;
                                    }
                                }

                                if(naoachou){
                                    alunos[x].informacoesBasica();
                                    System.out.println("cursando" + alunos[x].getCurso());
                                    if(alunos[x].getMatricula()){
                                        System.out.println("matriculado ativa");
                                    }
                                    else{
                                        System.out.println("matricula cancelado");
                                    }
                                    System.out.println("precisa atualizar algum dado?");
                                    String atualizar = scanner.nextLine();

                                    if(atualizar.equalsIgnoreCase("sim")){
                                        System.out.println("qual a campo atualização?");
                                        String resposta = scanner.nextLine();

                                        if(resposta.equalsIgnoreCase("nome")){
                                            System.out.println("informe o nome atualizado: ");
                                            String nomeatualizado = scanner.nextLine();
                                            alunos[x].setNome(nomeatualizado);
                                            System.out.println();
                                            System.out.println("voltando a o menu de busca de dados....");

                                        }
                                        else if(resposta.equalsIgnoreCase("sexo")){
                                            System.out.println("informe o sexo atualizado: ");
                                            String sexoatualizado = scanner.nextLine();
                                            alunos[x].setSexo(sexoatualizado);
                                            System.out.println("voltando a o menu de busca de dados....");
                                        }
                                        else if(resposta.equalsIgnoreCase("idade")){
                                            System.out.println("informe a idade atualizada: ");
                                            int idadeatualizada = scanner.nextInt();
                                            alunos[x].setIdade(idadeatualizada);
                                            System.out.println("voltando a o menu de busca de dados....");
                                            scanner.nextLine(); /// limpar buffer

                                        }
                                        else if(resposta.equalsIgnoreCase("matricula")){
                                            if(alunos[x].getMatricula()){
                                                System.out.println("matriculado ativa, deseja cancelar?");
                                                String cancelarmatricula = scanner.nextLine();
                                                if(cancelarmatricula.equalsIgnoreCase("sim")){
                                                    alunos[x].cancelarMatricula();
                                                }
                                                else{
                                                    System.out.println("nenhuma alteração , voltando a o menu de busca de dados....");
                                                }
                                            }
                                            else{
                                                System.out.println("matricula cancelada, deseja ativar?");
                                                String cancelarmatricula = scanner.nextLine();
                                                if(cancelarmatricula.equalsIgnoreCase("sim")){
                                                    alunos[x].setMatricula();
                                                }
                                                else{
                                                    System.out.println("nenhuma alteração , voltando a o menu de busca de dados....");
                                                }
                                            }
                                        }
                                        else if(resposta.equalsIgnoreCase("curso")){
                                            System.out.println("informe o curso atualizado: ");
                                        }
                                        else{
                                            System.out.println("opção invalida");
                                        }
                                    }
                                    else{
                                        System.out.println("voltando a o menu de busca de dados....");
                                    }
                                }
                                else{
                                    System.out.println("aluno não encontrado, voltando a o menu de busca de dados....");
                                }
                                break;

                            case 2 :
                                break;

                            case 3:
                                break;

                            case 4:
                                dados = false;
                                System.out.println("saindo da area de cadastro...");
                                break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("encerrando.....");
                    ativo = false;
                    break;

                default:
                    System.out.println("opção invalida");
            }

        }

    }
}