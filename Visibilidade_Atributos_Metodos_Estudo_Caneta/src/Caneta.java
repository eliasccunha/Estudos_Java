//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Caneta {
    public Scanner scanner;
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    protected boolean tampada;


    public Caneta(String m, String c, float p){
        this.tampar();
        this.modelo = m;
        this.cor = c;
        this.setPonta(p);
    }

    public String getModelo(){
        return  this.modelo;
    }
    public void setModelo(String m){
        this.modelo = m;
    }

    public float getPonta(){
        return this.ponta;
    }
    public void setPonta(float p){
        this.ponta = p;
    }





    public void status() {
        System.out.println("Modelo " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta " + this.ponta);
        System.out.println("Carga " + this.carga + "%");
        System.out.println("Está tampada? " + this.tampada);
    }

    public void rabisca() {
        if (this.carga > 0) {
            if (this.tampada) {
                System.out.println("a caneta esta tampada");
                System.out.println("Deseja Destamapar? Sim ou nao? (S/N)");
                Scanner scanner = new Scanner(System.in);
                char destampar_caneta_resposta = scanner.next().charAt(0);
                if (destampar_caneta_resposta == 'S' || destampar_caneta_resposta == 's') {
                    System.out.println("rabiscos da cor " + this.cor + " da caneta " + this.modelo + " com a ponta " + this.ponta);
                    System.out.println();
                    this.carga--;
                }
                else{
                    System.out.println("Não da pra rabiscar com a caneta tampada");
                }
            }
            else {
                System.out.println("rabiscos da cor " + this.cor + " da caneta " + this.modelo + " com a ponta " + this.ponta);
                System.out.println();
                this.carga--;
            }
        }
        else {
            System.out.println("Caneta sem carga");
        }

    }

    protected void tampar() {
        this.tampada = true;
    }

    protected void destampar() {
        this.tampada = false;
    }
}
