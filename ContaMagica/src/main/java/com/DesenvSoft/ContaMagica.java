package com.DesenvSoft;

public class ContaMagica {
    
    public static final int SILVER = 0;
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;
    public double saldo = 0;
    public int status;
    
    public double getSaldo(){
        return saldo;
    }
	
     public int getStatus(){
         return status;
          
     }
	
     public void deposito(int valor) throws INVALID_OPER_EXCEPTION{

     }

     public  void retirada(int valor) throws INVALID_OPER_EXCEPTION{

     }
}