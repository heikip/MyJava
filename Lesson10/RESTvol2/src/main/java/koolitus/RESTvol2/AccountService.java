package koolitus.RESTvol2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(String accountNr){
        return accountRepository.queryAccount(accountNr);
    }
    public void depositMoney(String accountNr, BigDecimal amount){
        Account tempAccount = getAccount(accountNr);
        BigDecimal temp = tempAccount.getAmount();
        temp = temp.add(amount);
        tempAccount.setAmount(temp);
        accountRepository.updateAccount(tempAccount.getAccountNr(), tempAccount.getAmount());
    }
    public void withdrawMoney(String accountNr, BigDecimal amount) {
        Account tempAccount = getAccount(accountNr);
        BigDecimal temp = tempAccount.getAmount();
        temp = temp.subtract(amount);
        if (temp.intValue()<0){
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Error not enough dinero");
            //oma exception throw myexception
            //throw new MyException(HttpStatus.I_AM_A_TEAPOT, "Error not enough dinero");
        }
        tempAccount.setAmount(temp);
        accountRepository.updateAccount(tempAccount.getAccountNr(), tempAccount.getAmount());
    }
    public void transferMoney(String accountFrom, String accountTo, BigDecimal amount){
        Account accFrom = getAccount(accountFrom);
        Account accTo = getAccount(accountTo);
        BigDecimal moneyFrom = accFrom.getAmount();
        moneyFrom = moneyFrom.subtract(amount);
        if (moneyFrom.intValue()<0){
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Error not enough dinero");
        }
        BigDecimal moneyTo = accTo.getAmount();
        moneyTo = moneyTo.add(amount);

        accFrom.setAmount(moneyFrom);
        accTo.setAmount(moneyTo);
        accountRepository.updateAccount(accFrom.getAccountNr(), accFrom.getAmount());
        accountRepository.updateAccount(accTo.getAccountNr(), accTo.getAmount());
    }
    public List getCustomerAccounts(String email){
        return accountRepository.getCustomerAccounts(email);
    }
    public Customer createCustomer(String firstName, String lastName, String email){
        Customer freshCustomer = new Customer(firstName, lastName, email);
        accountRepository.createCustomer(freshCustomer.getFirstName(), freshCustomer.getLastName(), freshCustomer.getEmail());
        return freshCustomer;
    }
    public Account createAccount(String accountNr, String email, BigInteger customerId){
        Long id = accountRepository.getCustomerId(email);
        if ( id.equals(0) ) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Error no customer found");
        }


        //List <Account> resultList = accountRepository.queryAccount(accountNr);
        Account checkAccount = accountRepository.queryAccount(accountNr);
        if (checkAccount!=null) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Error account exists");
        }
        Account freshAccount = new Account(accountNr, new BigDecimal("0"), customerId);
        return accountRepository.createAccount(freshAccount.getAccountNr(), freshAccount.getCustomerId());


    }

}
