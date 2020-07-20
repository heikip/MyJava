package koolitus.REST;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
@SpringBootTest
public class MathServiceTest {
    @Autowired
    public MathService mathService;

    @Test
    public void mathServiceTest() {

        assertEquals(new BigDecimal(4), mathService.multiply(new BigDecimal(2),new BigDecimal(2)));
      //  BigDecimal nr1 = new BigDecimal(2);
      //  BigDecimal nr2 = new BigDecimal(2);
      //  BigDecimal neli = new BigDecimal(4);
      //  BigDecimal vastus = mathService.multiply(nr1, nr2);

     //   assertEquals(neli, vastus);
    }
}
