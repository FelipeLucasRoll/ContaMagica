package com.DesenvSoft;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaMagicaTest{

    public ContaMagica cm;

    @BeforeEach
    public void setup(){
        this.cm = new ContaMagica();
    }


    @Test
    public void saldoNegativo(){
        cm.deposito(10);
        cm.retirada(1000);
        double result = cm.getSaldo();
      Assertions.assertEquals(0, result) ;
    }

    @Test
    public void status01(){
        cm.deposito(50000);
        double result = cm.getStatus();
      Assertions.assertEquals(1, result) ;
    }

    @Test
    public void status12(){
        cm.deposito(50000);
        cm.deposito(150000);
        double result = cm.getStatus();
      Assertions.assertEquals(2, result) ;
    }

    @Test
    public void statusValorizado(){
        cm.deposito(50000);
        cm.deposito(150000);
        double result = cm.getSaldo();
      Assertions.assertEquals(201500, result) ;
    }

    @Test
    public void status21(){
        cm.deposito(100000);
        cm.deposito(100000);
        cm.retirada(105000);
        double result = cm.getStatus();
      Assertions.assertEquals(1, result) ;
    }

    @Test
    public void status21Exagero(){
        cm.deposito(100000);
        cm.deposito(100000);
        cm.retirada(105000000);
        double result = cm.getStatus();
      Assertions.assertEquals(1, result) ;
    }

    @Test
    public void status10Exagero(){
        cm.deposito(100000);
        cm.retirada(760000000);
        System.out.println(cm.getSaldo());
        double result = cm.getStatus();
      Assertions.assertEquals(0, result) ;
    }
    

    @Test
    public void status10(){
        cm.deposito(100000);
        cm.retirada(76000);
        double result = cm.getStatus();
      Assertions.assertEquals(0, result) ;
    }

}