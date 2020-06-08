package koolitus.REST.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@RequestMapping("sequence")
@RestController()
public class SequenceController {
    // TODO
    // luua endpoint mis leiab 3n+1 jada pikkuse sisestatud numbrist-- eelnevatest ülessannetest
    @GetMapping("seq")
    public int sequence(@RequestParam("a")int jadaliige){
           //System.out.println(jadaliige);
            int counter = 1;
            while (jadaliige != 1 ) {
                if (jadaliige % 2 == 1) {
                    jadaliige = jadaliige * 3 + 1;
                    //System.out.println(jadaliige);
                    counter++;
                } else {
                    jadaliige = jadaliige / 2;
                    //System.out.println(jadaliige);
                    counter++;
                }
            }
            //System.out.println(counter+" jadaliiget");
            return counter;
        }
       // luua endpoint mis trükib välja fibonacci jada n esimest elementi
       @GetMapping("/fibN")
       public  List<BigInteger> fibonacciN(@RequestParam("fibnr")BigInteger nr) {
           BigInteger fib1 = new BigInteger("0");
           BigInteger fib2 = new BigInteger("1");
           BigInteger fib = new BigInteger("0");
           List<BigInteger> fibList= new LinkedList<BigInteger>();
           fibList.add(new BigInteger("0"));
           fibList.add(new BigInteger("1"));

           for (int i = 1; i < nr.intValue(); i++) {
               fib = fib1.add(fib2);
               fibList.add(fib);
               fib1 = fib2;
               fib2 = fib;
           }
           return fibList;
       }

    // luua endpoint mis leiab kas sisestatud arv on algarv või mitte
    @GetMapping("/isPrime")
    public boolean isPrime(@RequestParam("a")int arv) {
        int jagaja = 2;
/// kui arvestada ka sellega et kui 2'ga juba ei jagu, siis pole mõtet kontrollida, kas 4,6,8,10 jne paarisarvuga jagub
        while ( jagaja <= arv/2 ) {
            if (arv % jagaja == 0) {
                return false;
            }
            jagaja++;
        }
        return true;
    }

}
