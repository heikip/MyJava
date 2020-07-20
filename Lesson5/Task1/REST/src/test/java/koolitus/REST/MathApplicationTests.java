package koolitus.REST;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
@SpringBootTest
 public class MathApplicationTests {
    @Autowired
    private MathService mathService;

    @Test
    public void mathServiceTest() {
        assertEquals(4, mathService.multiply(new BigDecimal(2),new BigDecimal(2)));
    }
}
