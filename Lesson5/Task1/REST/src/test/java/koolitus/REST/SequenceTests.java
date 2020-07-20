package koolitus.REST;

//import org.junit.Test;// miskipärast see on sobiv import, kuid ei tööta et service't testida
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class SequenceTests {
    @Autowired
    public SequenceService sequenceService;

    @Test
    public void primeTest() {
        assertEquals(false, sequenceService.isPrime(4));
    }
}