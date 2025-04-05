import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Professor[]professores = new Professor[50];
        Aluno[]alunos = new Aluno[50];
        Funcionario[] funcionarios = new Funcionario[50];

        for (int i = 0; i < 50 ; i++){
            alunos[i] = new Aluno();
            professores[i] = new Professor();
            funcionarios[i] = new Funcionario();
        }

        boolean ativo = true;
        int i = 0, j = 0, p = 0;




        while(ativo){
            System.out.println("informe o cadastro a ser feito");
            System.out.println("digite 1 para professor, 2 para aluno , 3 para funcionario");
            System.out.println("para alterar dados cadastrado digite 4 e para fechar 5");

            int escolha = scanner.nextInt();
            int idade;
            String sexo;
            scanner.nextLine(); /// limpar buffer

            switch (escolha){
                case 1:
                    if(i < 50) {
                        System.out.println("=== cadastro professor ===");
                        System.out.println("infome o nome do professor :");
                        String nomecadastroprofessor = scanner.nextLine();
                        System.out.println("sexo: ");
                        sexo = scanner.nextLine();
                        System.out.println("qual a especialidade: ");
                        String especilidade = scanner.nextLine();
                        System.out.println("idade: ");
                        idade = scanner.nextInt();
                        System.out.println("informe o salario: ");
                        float salario = scanner.nextFloat();
                        scanner.nextLine(); /// limpar buffer



                        professores[i].setNome(nomecadastroprofessor);
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
                    if(j < 50){
                        System.out.println("=== cadastro Aluno ===");
                        System.out.println("informe o nome do aluno: ");
                        String nomecadastroaluno = scanner.nextLine();
                        System.out.println("sexo: ");
                        sexo = scanner.nextLine();
                        System.out.println("qual curso: ");
                        String curso = scanner.nextLine();
                        System.out.println("idade: ");
                        idade = scanner.nextInt();
                        scanner.nextLine(); /// limpar buffer

                        alunos[j].setNome(nomecadastroaluno);
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
                    if(p < 50){
                        System.out.println("=== cadastro funcionario ===");
                        System.out.println("informe o nome do funcionario: ");
                        String nomecadastrofuncionario = scanner.nextLine();
                        System.out.println("sexo: ");
                        sexo = scanner.nextLine();
                        System.out.println("qual o setor: ");
                        String setor = scanner.nextLine();
                        System.out.println("qual a idade: ");
                        idade = scanner.nextInt();
                        System.out.println("salario: ");
                        scanner.nextLine(); /// limpar o buffer

                        float salario = scanner.nextFloat();
                        funcionarios[p].setNome(nomecadastrofuncionario);
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
                        boolean naoachou = true;
                        int x;
                        String resposta;
                        String atualizar;
                        switch (cadastro){



                            case 1:
                                naoachou = true;
                                System.out.println("informe o nome do professor: ");
                                String nomecadastro = scanner.nextLine();

                                for(x = 0; x < 50; x++){
                                    if(professores[x].getNome().equalsIgnoreCase(nomecadastro)){
                                        naoachou = false;
                                        break;
                                    }
                                }
                                if(!naoachou){
                                    professores[x].informacoesBasica();
                                    System.out.println("da aula na area " + professores[x].getEspecialidade());
                                    System.out.println("salario: "+ professores[x].getSalario());
                                    System.out.println("Deseja atualizar algum dado?");
                                    atualizar = scanner.nextLine();
                                    if(atualizar.equalsIgnoreCase("sim")){
                                        System.out.println("informe o dado a ser atualizado:");
                                        resposta = scanner.nextLine();
                                        if(resposta.equalsIgnoreCase("nome")){
                                            System.out.println("informe o nome atualizado: ");
                                            String nomeatualizado = scanner.nextLine();
                                            professores[x].setNome(nomeatualizado);

                                        }
                                        else if(resposta.equalsIgnoreCase("sexo")){
                                            System.out.println("informe o sexo atualizado: ");
                                            String sexoatualizado = scanner.nextLine();
                                            professores[x].setSexo(sexoatualizado);
                                        }
                                        else if(resposta.equalsIgnoreCase("idade")){
                                            System.out.println("informe a idade atualizada: ");
                                            int idadeatualizada = scanner.nextInt();
                                            professores[x].setIdade(idadeatualizada);
                                            scanner.nextLine(); /// limpar buffer

                                        }
                                        else if(resposta.equalsIgnoreCase("especialidade")){
                                            System.out.println("informe a especialidade atualizada: ");
                                            String especialidadeatualizada = scanner.nextLine();
                                            professores[x].setEspecialidade(especialidadeatualizada);

                                        }
                                        else if(resposta.equalsIgnoreCase("salario")){
                                            System.out.println("informe o salario atualizadao: ");
                                            float salarioatuaizado = scanner.nextFloat();
                                            professores[x].setSalario(salarioatuaizado);
                                            scanner.nextLine(); /// limpar buffer;
                                        }
                                        else{
                                            System.out.println("opção invalida");
                                        }
                                    }
                                    System.out.println("voltando ao menu...");

                                }
                                else{
                                    System.out.println("Professor nao localizado, voltando ao menu...");
                                }
                                break;



                            case 2 :
                                naoachou = true;
                                System.out.println("informe o nome do aluno: ");
                                String nomebusca = scanner.nextLine();

                                for(x = 0 ; x < 50 ; x++){
                                    if(alunos[x].getNome().equals(nomebusca)){
                                        naoachou = false;
                                        break;
                                    }
                                }

                                if(!naoachou){
                                    alunos[x].informacoesBasica();
                                    System.out.println("cursando " + alunos[x].getCurso());
                                    if(alunos[x].getMatricula()){
                                        System.out.println("matriculado ativa");
                                    }
                                    else{
                                        System.out.println("matricula cancelado");
                                    }
                                    System.out.println("precisa atualizar algum dado?");
                                    atualizar = scanner.nextLine();

                                    if(atualizar.equalsIgnoreCase("sim")){
                                        System.out.println("qual a campo atualização?");
                                        resposta = scanner.nextLine();

                                        if(resposta.equalsIgnoreCase("nome")){
                                            System.out.println("informe o nome atualizado: ");
                                            String nomeatualizado = scanner.nextLine();
                                            alunos[x].setNome(nomeatualizado);

                                        }
                                        else if(resposta.equalsIgnoreCase("sexo")){
                                            System.out.println("informe o sexo atualizado: ");
                                            String sexoatualizado = scanner.nextLine();
                                            alunos[x].setSexo(sexoatualizado);

                                        }
                                        else if(resposta.equalsIgnoreCase("idade")){
                                            System.out.println("informe a idade atualizada: ");
                                            int idadeatualizada = scanner.nextInt();
                                            alunos[x].setIdade(idadeatualizada);
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
                                            String cursoatualizado = scanner.nextLine();
                                            alunos[x].setCurso(cursoatualizado);
                                        }
                                        else{
                                            System.out.println("opção invalida");
                                        }
                                    }
                                    System.out.println("voltando a o menu de busca de dados....");
                                }
                                else{
                                    System.out.println("aluno não encontrado, voltando a o menu de busca de dados....");
                                }

                                break;

                            case 3:
                                naoachou = true;
                                System.out.println("informe o nome do funcionario");
                                String nome = scanner.nextLine();
                                for(x = 0 ; x < 50; x++){
                                    if(funcionarios[x].getNome().equalsIgnoreCase(nome)){
                                        naoachou = false;
                                        break;
                                    }
                                }
                                if(!naoachou){
                                    funcionarios[x].informacoesBasica();
                                    System.out.println("trabalha no setor "+ funcionarios[x].getSetor());
                                    System.out.println("salario: "+ funcionarios[x].getSalario());
                                    funcionarios[x].statusTrabalho();
                                    System.out.println("deseja atualizar algum dado?");
                                    atualizar = scanner.nextLine();
                                    if(atualizar.equalsIgnoreCase("sim")){
                                        System.out.println("qual dado vai ser atualizado?");
                                        resposta = scanner.nextLine();
                                        if(resposta.equalsIgnoreCase("nome")){
                                            System.out.println("informe o nome atualizado: ");
                                            String nomeatualizado = scanner.nextLine();
                                            funcionarios[x].setNome(nomeatualizado);
                                        }
                                        else if( resposta.equalsIgnoreCase("sexo")){
                                            System.out.println("qual o sexo atualizado: ");
                                            String sexoatualizado = scanner.nextLine();
                                            funcionarios[x].setSexo(sexoatualizado);
                                        }
                                        else if(resposta.equalsIgnoreCase("idade")){
                                            System.out.println("qual a idade atualizada: ");
                                            int idadeatualizada = scanner.nextInt();
                                            funcionarios[x].setIdade(idadeatualizada);
                                            scanner.nextLine(); /// limpar o buffer
                                        }
                                        else if(resposta.equalsIgnoreCase("salario")){
                                            System.out.println("informe o salario atualizado: ");
                                            float salarioatualizado = scanner.nextFloat();
                                            funcionarios[x].setSalario(salarioatualizado);
                                        }
                                        else if(resposta.equalsIgnoreCase("setor")){
                                            System.out.println("informe o setor atualizado: ");
                                            String setoratualizado = scanner.nextLine();
                                            funcionarios[x].setSetor(setoratualizado);
                                        }
                                    }
                                }
                                else{
                                    System.out.println("funcionario nao localizado!");

                                }
                                System.out.println("voltando ao menu de busca de dados...");
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