package koolitus.REST.Controller;
import java.math.BigInteger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FibonacciController {

    @GetMapping("/fibbonacci")
    public  BigInteger fibonacci1(@RequestParam("fibnr")BigInteger nr) {
        BigInteger fib1 = new BigInteger("0");
        BigInteger fib2 = new BigInteger("1");
        BigInteger fib = new BigInteger("0");

        System.out.print(fib1+" ");
        System.out.print(fib2+" ");
        for (int i = 1; i < nr.intValue(); i++) {
            fib = fib1.add(fib2);
            fib1 = fib2;
            fib2 = fib;
            System.out.println(String.format(i+"'s:%d ", fib));
        }
        //System.out.println(fib);
        //return 0;
        return fib;
    }


}




