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
	
     public void deposito(int valor) throws INVALID_OPER_EXCEPTION{

        if(this.getStatus() == 0){

            this.saldo = this.saldo + valor;
             if(this.saldo >= 50000){
                 this.status = 1;
             }
        }

        if(this.getStatus() == 1){

            this.saldo = this.saldo + (valor * 1.01);
            if(this.saldo >= 200000){
                this.status = 2;
             }
        }

        if(this.getStatus() == 2){
            this.saldo = this.saldo + (valor * 2.5);
        }
     }

     public  void retirada(int valor) throws INVALID_OPER_EXCEPTION{

        if(this.getStatus() == 0){
            this.saldo = this.saldo - valor;

            if(this.saldo < 0){
                this.saldo = 0;        
            }

        }

        if(this.getStatus() == 1){
            this.saldo = this.saldo - valor;

            if(this.saldo < 25000 ){
                this.status = 0;


            if(this.saldo < 0){
                this.saldo = 0;
            }
        }

        if(this.getStatus() == 2){
            this.saldo = this.saldo - valor;

            if(this.saldo < 100000 ){
                this.status = 1;

            if(this.saldo < 0){
                this.saldo = 0;
            }

        }


     }
}