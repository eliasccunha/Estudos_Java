public class Conta {
    private String titular;
    private int numero;  // 4 numeros
    private int agencia; // cinco numero
    private int digito;  // 1 digito
    private int saldo;
    private int depositar;
    private int saque;
    private int senha;

public Conta(int numero, int agencia, int digito){
    this.numero = numero;
    this.agencia = agencia;
    this.digito = digito;
    this.saldo = 0;
}

    public int setSenha(int senha){
        return this.senha = senha;
    }

    public int getsenha(){
        return this.senha;
    }

    public String getTitular(){
        return this.titular;
    }
    public void setTitular(String t){
        this.titular = t;
    }

    public int getNumero(){
        return this.numero;
    }
    public void setNumero(int nu){
        this.numero = nu;
    }

    public int getAgencia(){
        return this.agencia;
    }
    public void setAgencia(int ag){
        this.agencia = ag;
    }

    public int getDigito(){
        return this.digito;
    }

    public void setDigito(int dig){
        this.digito = dig;
    }
    public void Dados_Da_Conta(){
        System.out.println("Titular da conta: "+ this.getTitular());
        System.out.println("Agencia: " + this.getAgencia() + " numero: " + this.getNumero() + " digito: " + this.getDigito());
    }

    public void setDepositar( int deposito){
       saldo += deposito;
       System.out.println("Saldo total: "+ saldo);
    }
    public void setSaque(int saque){
        if(saque> saldo){
            System.out.println("Fundos insuficientes, saldo total: " + saldo);
        }
        else{
            saldo -= saque;
            System.out.println("Saldo total: "+ saldo);
        }
    }
    public int getsaldo(){
        return saldo;
    }

    public int mostrarSaldo(){
        return saldo;
    }


    public static boolean verificarDigitos(int num) {
        return String.valueOf(Math.abs(num)).length() == 6;
    }


}

