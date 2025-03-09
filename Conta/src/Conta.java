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
}

    public int setSenha(int senha){
        return this.senha = senha;
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
    }
    public void setSaque(int saque){
        saldo += saque;
    }


    public int mostrarSaldo(){
        return saldo;
    }


    public static boolean verificarDigitos(int num) {
        return String.valueOf(Math.abs(num)).length() == 6;
    }


}

