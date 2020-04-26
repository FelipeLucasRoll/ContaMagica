package com.DesenvSoft;

public class ContaMagica {
    
    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;
    public double saldo;
    public int status;


    public ContaMagica(){
        saldo = 0;
        status = 0;

    }
    
    public double getSaldo(){
        return saldo;
    }
	
     public int getStatus(){
         return status;
          
     }

 public void deposito(int valor) throws InvalidOperException
     {

        if(valor <=0 ){
            throw new InvalidOperException("Esta operação requer um valor maior ou igual a zero");
        }

        if(this.getStatus() == 0){

            this.saldo = this.saldo + valor;
             if(this.saldo >= 50000){
                 this.status = 1;
                }
        }

       else if(this.getStatus() == 1){

            this.saldo = this.saldo + (valor * 1.01);
            if(this.saldo >= 200000){
                this.status = 2;
             }
        }

       else if(this.getStatus() == 2){
            this.saldo = this.saldo + (valor * 2.5);
        }

    }



public void retirada(int valor) throws InvalidOperException{

    if(valor <=0 ){
        throw new InvalidOperException("Esta operação requer um valor maior ou igual a zero");
    }
        double saldoInicial = this.saldo;
        this.saldo = this.saldo - valor;
        if(this.saldo < 0){
            this.saldo = saldoInicial;
            throw new InvalidOperException("Esta operação resultaria em saldo inferior a zero e foi abortada. Nenhuma modificação foi realizada");
        }

        if(this.getStatus() == 1){
            if(this.saldo < 25000 ){
                this.status = 0;
            }
        }

        else if(this.getStatus() == 2){
            if(this.saldo < 100000 ){
                this.status = 1;
            }
         }
}

}
