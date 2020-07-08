package koolitus.RESTvol2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

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

}
