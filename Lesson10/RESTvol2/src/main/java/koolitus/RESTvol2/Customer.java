package koolitus.RESTvol2;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Customer {
    @Size(min = 1, max = 100)
    private String firstName;
    @Size(min = 1, max = 100)
    private String lastName;
    @Email
    private String email;

    public Customer (String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email= email;

    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }
}
