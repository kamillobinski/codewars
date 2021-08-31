import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class OrdersSummaryTest { 
  @Test
  public void test0() { 
    String l = "GOOG 90 160.45 B, JPMC 67 12.8 S, MYSPACE 24.0 210 B, CITI 50 450 B, CSCO 100 55.5 S";
      assertEquals("Buy: 14440 Sell: 6408; Badly formed 2: MYSPACE 24.0 210 B ;CITI 50 450 B ;",
                OrdersSummary.balanceStatements(l));
  }
  
  @Test
  public void test1() { 
    String l = "GOOG 300 542.0 B, AAPL 50 145.0 B, CSCO 250.0 29 B, GOOG 200 580.0 S";
      // Buy: 169850 Sell: 116000; Badly formed 1: CSCO 250.0 29 B ;
      assertEquals("Buy: 169850 Sell: 116000; Badly formed 1: CSCO 250.0 29 B ;",
          OrdersSummary.balanceStatements(l));
  }
  @Test
  public void test2() { 
    String l = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B";
      // Buy: 29499 Sell: 0   
      assertEquals("Buy: 29499 Sell: 0",
          OrdersSummary.balanceStatements(l));
  }
  @Test
  public void test3() { 
    String l = "GOOG 300 542.93 B, CLH15.NYM 50 56.32 S, CSCO 250 29.46 B, OGG 20 580.1 B";
    // Buy: 181846 Sell: 2816 
      assertEquals("Buy: 181846 Sell: 2816",
          OrdersSummary.balanceStatements(l));
  }
  @Test
  public void test4() { 
    String l = "ZNGA 1300 2.66 B, GOOG 200 580.12 S, OWW 1000 11.623 B, BAC 200 16.67 B";
    // Buy: 18415 Sell: 116024  
      assertEquals("Buy: 18415 Sell: 116024",
          OrdersSummary.balanceStatements(l));
  }
  @Test
  public void test5() { 
    String l = "ZNGA 1300 2.66 S, CLH15.NYM 50 56.32 S, OWW 1000 11.623 S, OGG 20 580.1 S";
    // Buy: 0 Sell: 29499
      assertEquals("Buy: 0 Sell: 29499",
          OrdersSummary.balanceStatements(l));
  }
  @Test
  public void test6() { 
    String l = "";
    // Buy: 0 Sell: 0
      assertEquals("Buy: 0 Sell: 0",
          OrdersSummary.balanceStatements(l));
  }
  @Test
  public void test7() { 
    String l = "ZNGA 1300 2.66, CLH15.NYM 50 56.32 S, OWW 1000 11.623 S, OGG 20 580.1 S";
    // Buy: 0 Sell: 26041; Badly formed 1: ZNGA 1300 2.66 ;
      assertEquals("Buy: 0 Sell: 26041; Badly formed 1: ZNGA 1300 2.66 ;",
          OrdersSummary.balanceStatements(l));
  }
  @Test
  public void test8() { 
    String l = "CAP 1300 .2 B, CLH16.NYM 50 56 S, OWW 1000 11 S, OGG 20 580.1 S";
    // Buy: 260 Sell: 11602; Badly formed 2: CLH16.NYM 50 56 S ;OWW 1000 11 S ;
      assertEquals("Buy: 260 Sell: 11602; Badly formed 2: CLH16.NYM 50 56 S ;OWW 1000 11 S ;",
          OrdersSummary.balanceStatements(l));
  }
  
}