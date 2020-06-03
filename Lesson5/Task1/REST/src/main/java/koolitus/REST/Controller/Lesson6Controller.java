package koolitus.REST.Controller;

import koolitus.REST.Httpcats;
import koolitus.REST.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
public class Lesson6Controller {

    LinkedList workers = new LinkedList();

    ///empolyees (GET)
    @GetMapping("employees")

    ///employee/{id} (GET)
    @GetMapping("employee/{id}")

    ///employee/{id} (PUT)
    @PutMapping("employee/{id}")

    ///employee (POST)
    @PostMapping("/employee")

    ///employee/{id] (DELETE
    @PostMapping("/employee/{id}")



///////////////
    @GetMapping("/sethttpcats/{code}")
    public Httpcats sethttpcats(@PathVariable("code") String httpcode) {
        Httpcats newhttpcats = new Httpcats();
        newhttpcats.setStatus(httpcode);
        newhttpcats.setAnnotation("Uri");
        newhttpcats.setUrl("https://http.cats");
        //newhttpcats.getStatus();
        return newhttpcats;
    }
    //@PostMapping("/reqhttpcats/")
    @PostMapping(path = "/reqhttpcats", consumes = "application/json", produces = "application/json")
    public Httpcats reqhttpcats(@RequestBody Httpcats newhttpcats) {
        //newhttpcats.setStatus(httpcode);
        //newhttpcats.setAnnotation("Uri");
        //newhttpcats.setUrl("https://http.cats");
        //newhttpcats.getStatus();
        return newhttpcats;
    }

    @GetMapping("/gethttpdcats")
    public Httpcats gethttpcats( Httpcats newhttpcats) {
        Httpcats httpcatsobject = newhttpcats;
        httpcatsobject.getUrl();
        return httpcatsobject;
        //return new String("https://http.cat/"+httpcode.toString(httpcode));'
        //return httpcats.getStatus
    }




}
