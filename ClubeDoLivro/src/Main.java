
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe quantas pessoas vão participar do clube: ");
        int participantes = scanner.nextInt();
        scanner.nextLine();
        Pessoa[]pessoas = new Pessoa[participantes];
        Livro[]livros = new Livro[participantes];


        for(int i = 0; i < participantes;i++){
            // cadastrar pessoa
            System.out.printf("informe o nome da pessoa %d ", i + 1);
            String nome = scanner.nextLine();
            System.out.printf("informe o sexo %d ",i+1);
            String sexo = scanner.nextLine();
            System.out.printf("informe a idade %d ",i+1);
            int idade = scanner.nextInt();
            scanner.nextLine();
            pessoas[i] = new Pessoa(nome, sexo, idade);


            //cadastrar livro
            System.out.printf("qual o titulo do livro %d ", i + 1);
            String livrotitulo = scanner.nextLine();
            System.out.printf("qual o autor %d ", i + 1);
            String autorlivro = scanner.nextLine();
            System.out.printf("quantas paginas %d ", i + 1);
            int totalpaginas = scanner.nextInt();
            scanner.nextLine();
            livros[i] = new Livro(livrotitulo, autorlivro, totalpaginas);
            livros[i].setDono(pessoas[i]);
        }

       
        for (int i = 0 ; i < participantes; i++){
            for(int j = 0 ; j < participantes - 1 - i; j++){
                if(livros[j].getTotaldepaginas() > livros[j + 1].getTotaldepaginas()){
                    Pessoa tempPessoa = pessoas[j];
                    Livro tempLivro = livros[j];
                    pessoas[j] = pessoas[j + 1];
                    livros[j] = livros[j + 1];
                    pessoas[j + 1] = tempPessoa;
                    livros[j + 1] = tempLivro;
                }
            }
        }

        System.out.println("O livro com mais paginas é " + livros[participantes - 1].getTitulo());
        System.out.println("Com o total de " + livros[participantes - 1 ].getTotaldepaginas());
        System.out.println("O livro é do(a) " + pessoas[participantes - 1].getNome());


    }
}