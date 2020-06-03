package koolitus.REST.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class EmployeeController {
    @GetMapping("/employee/{id}")
    public String employeeroot(@PathVariable("id") Long id) {
        //  return new String(id.toString(id*id));
        return new String(id.toString(id * id));
    }
    @GetMapping("/employee")
    public String employee(@RequestParam("employeeId") Long id) {
        return new String(id.toString(id * id));
    }
}
