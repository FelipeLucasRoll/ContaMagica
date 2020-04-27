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


    //@Test
    //public void saldoNegativo(){
    //    cm.deposito(10);
    //    cm.retirada(1000);
    //    double result = cm.getSaldo();
    //  Assertions.assertEquals(0, result) ;
    //}

    //@Test
    //public void status01(){
    //    cm.deposito(50000);
    //    double result = cm.getStatus();
    //  Assertions.assertEquals(1, result) ;
    //}
	
	@Test
    public void status01v2() throws InvalidOperException {
        cm.deposito(50001);
        double result = cm.getStatus();
      Assertions.assertEquals(1, result) ;
    }
	
	@Test
    public void status01False() throws InvalidOperException {
        cm.deposito(49999);
        double result = cm.getStatus();
      Assertions.assertEquals(0, result) ;
    }

    @Test
    public void status12() throws InvalidOperException {
        cm.deposito(50000);
        cm.deposito(150000);
        double result = cm.getStatus();
      Assertions.assertEquals(2, result) ;
    }
	
	@Test
    public void status12v2() throws InvalidOperException {
        cm.deposito(50000);
        cm.deposito(150001);
        double result = cm.getStatus();
      Assertions.assertEquals(2, result) ;
    }
	
	@Test
    public void status12False() throws InvalidOperException {
        cm.deposito(50000);
        cm.deposito(110000);
        double result = cm.getStatus();
      Assertions.assertEquals(1, result) ;
    }

    @Test
    public void statusValorizado() throws InvalidOperException {
        cm.deposito(50000);
        cm.deposito(150000);
        double result = cm.getSaldo();
      Assertions.assertEquals(201500, result) ;
    }

    @Test
    public void status21() throws InvalidOperException {
        cm.deposito(100000);
        cm.deposito(100000);
        cm.retirada(105000);
        double result = cm.getStatus();
      Assertions.assertEquals(1, result) ;
    }
	
	@Test
    public void status21False() throws InvalidOperException {
        cm.deposito(100000);
        cm.deposito(100000);
        cm.retirada(50000);
        double result = cm.getStatus();
      Assertions.assertEquals(2, result) ;
    }


    @Test
    public void status2() throws InvalidOperException {
        cm.deposito(100000);
        cm.deposito(100000);
        cm.deposito(100);
        double result = cm.getSaldo();
      Assertions.assertEquals(201102.5, result) ;
    }

    //@Test
    //public void status21Exagero() throws InvalidOperException {
    //    cm.deposito(100000);
    //    cm.deposito(100000);
    //    cm.retirada(105000000);
    //    double result = cm.getStatus();
    //  Assertions.assertEquals(2, result) ;
    //}

    //@Test
    //public void status10Exagero() throws InvalidOperException {
    //    cm.deposito(100000);
    //    cm.retirada(760000000);
    //    System.out.println(cm.getSaldo());
    //    double result = cm.getStatus();
    //  Assertions.assertEquals(0, result) ;
    //}
    


    @Test
    public void status10() throws InvalidOperException {
        cm.deposito(100000);
        cm.retirada(76000);
        double result = cm.getStatus();
      Assertions.assertEquals(0, result) ;
    }
	
	@Test
    public void status10False() throws InvalidOperException {
        cm.deposito(100000);
        cm.retirada(20000);
        double result = cm.getStatus();
      Assertions.assertEquals(1, result) ;
    }

    @Test
    void testException1() {
      Assertions.assertThrows(InvalidOperException.class, () -> {cm.deposito(-100);
    });
 
    }

    @Test
    void testException2() {
      Assertions.assertThrows(InvalidOperException.class, () -> {cm.retirada(-100);;
    });

    }


    @Test
    void testException3() {
      Assertions.assertThrows(InvalidOperException.class, () -> {cm.retirada(100);
    });

    }
    }