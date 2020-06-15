package koolitus.REST.Controller;
import koolitus.REST.Account;

import koolitus.REST.MyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("mybank")
@RestController()
public class BankController {
    // TODO
    // kasuta staatilist muutujat andmete salvestamiseks
    ///private static int counter;
    private static Map<String, Account> accounts = new HashMap();
    //private static Map<Integer, BigInteger> Amounts = new HashMap();
    //private static Map<String, BigInteger>

    // defineeri rest enpoindid
    // createAccount(String accountNr) | loob uue konto etteantud konto numbriga
    @GetMapping("createAccount")
    public Account createAccount(@RequestParam("accountNr")String accountNr){
       accounts.put(accountNr, new Account(accountNr, new BigDecimal("0")));
      return accounts.get(accountNr);
    }
    // getAccount(String accountNr) | tagasta kui palju raha on vastaval kontol
    @GetMapping("getAccount")
    public Account getAccount(@RequestParam("accountNr")String accountNr){
        return accounts.get(accountNr);
    }
    // depositMoney(String accountNr, amount) | kannab loodud kontole raha (suurendab kontoga seotud raha muutujat)
    @GetMapping("depositMoney")
    public Account depositMoney(@RequestParam("accountNr")String accountNr, @RequestParam("amount") BigDecimal amount){
        Account tempaccount = accounts.get(accountNr);
        BigDecimal temp = tempaccount.getAmount();
        temp = temp.add(amount);
        tempaccount.setAmount(temp);
        accounts.put(accountNr, tempaccount);
    return accounts.get(accountNr);
    }
    // withdrawMonet(String accountNr, amount) | võtab kontolt raha (vähendab kontol olevat rahasummat)
    @GetMapping("withdrawMoney")
    public Account withdrawMoney(@RequestParam("accountNr")String accountNr, @RequestParam("amount") BigDecimal amount){
        Account tempaccount = accounts.get(accountNr);
        BigDecimal temp = tempaccount.getAmount();
        temp = temp.subtract(amount);
        if (temp.intValue()<0){
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Error not enough dinero");
            //oma exception throw myexception
            throw new MyException(HttpStatus.I_AM_A_TEAPOT, "Error not enough dinero");
                    }
        tempaccount.setAmount(temp);
        accounts.put(accountNr, tempaccount);
        return accounts.get(accountNr);
    }
    // transferMoney(String account1, String account2, amount) | kanna raha esimeselt kontolt teisele kontole
    @GetMapping("transferMoney")
    public Account transferMoney(@RequestParam("accountFrom")String accountFrom, @RequestParam("accountTo")String accountTo, @RequestParam("amount") BigDecimal amount){
        Account accFrom = accounts.get(accountFrom);
        Account accTo = accounts.get(accountTo);
        BigDecimal moneyFrom = accFrom.getAmount();
        moneyFrom = moneyFrom.subtract(amount);
        if (moneyFrom.intValue()<0){
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Error not enough dinero");
        }
        BigDecimal moneyTo = accTo.getAmount();
        moneyTo = moneyTo.add(amount);

        accFrom.setAmount(moneyFrom);
        accTo.setAmount(moneyTo);

        accounts.put(accountFrom, accFrom);
        accounts.put(accountTo, accTo);

        return accounts.get(accountFrom);
    }

}