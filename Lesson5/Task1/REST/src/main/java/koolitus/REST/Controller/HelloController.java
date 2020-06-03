package koolitus.REST.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping(value="/Hello")
    public String getHelloWorld(){
        return "Hello. There is nothing here. What do you want?  ";
    }

}
