package koolitus.REST.Controller;

import koolitus.REST.MathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;


@RequestMapping
@RestController()
public class MathController {
    public MathService mathService;
    // TODO, loo endpoint, mis sisaldaks GET teenuseid
    // *multiply (korruta 2 arvu)
    @GetMapping("mul")
    public BigDecimal multiply(@RequestParam("a")BigDecimal a, @RequestParam("b") BigDecimal b){
        //return a.multiply(b);
        return mathService.multiply(a,b);
    }
    // *divide (jaga 2 arvu)
    @GetMapping("div")
    public BigDecimal divide(@RequestParam("a")BigDecimal a, @RequestParam("b") BigDecimal b){
        return  a.divide(b, 2 , RoundingMode.HALF_UP);
    }
    // *abs (tagasta absoluut väärtus)
    @GetMapping("abs")
    public BigDecimal abs(@RequestParam("a")BigDecimal a){
        return a.abs();
    }
    // *min (tagasta 2-st arvust kõige väiksem)
    @GetMapping("min")
    public BigDecimal minimum(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b){
            //return Math.min(a.floatValue(),b.floatValue()); -- peab meetodi kah float'iks tegema, kaob BigDecimal kasutamise mõte
        return a.min(b);
    }
    // *max (tagasta 2-st arvust kõige suurem)
    @GetMapping("max")
    public BigDecimal maximum(@RequestParam("a") BigDecimal a, @RequestParam("b") BigDecimal b){
        return a.max(b);
    }
}