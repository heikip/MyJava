package koolitus.RESTvol2.controller;
import koolitus.RESTvol2.Account;
import koolitus.RESTvol2.AccountRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RequestMapping("mybank")
@RestController()
public class BankController {
    // TODO
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    // kasuta staatilist muutujat andmete salvestamiseks
    ///private static int counter;
    private Map<String, Account> accounts = new HashMap();
    //private static Map<Integer, BigInteger> Amounts = new HashMap();
    //private static Map<String, BigInteger>

    // defineeri rest enpoindid
    // createAccount(String accountNr) | loob uue konto etteantud konto numbriga
    @GetMapping("createAccount")
    private Account createAccount(@RequestParam("accountNr")String accountNr){
  /*     accounts.put(accountNr, new Account(accountNr, new BigDecimal("0")));

        String sql= "INSERT INTO accounts (account_nr);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new ObjectRowMapper());*/
      return accounts.get(accountNr);
    }
    // getAccount(String accountNr) | tagasta kui palju raha on vastaval kontol
    @GetMapping("getAccount")
        private List getAccount(@RequestParam("accountNr")String accountNr){
        String sql= "SELECT * FROM accounts WHERE account_nr = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
       return resultList;
        // jdbcTemplate.query();
       // return accounts.get(accountNr);
    }
    @GetMapping("getCustomerAccounts")
    private List getCustomerAccounts(@RequestParam("email")String email){
        String sql= "SELECT * FROM accounts WHERE customer_id = (select id from customers where email = :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return resultList;
        // jdbcTemplate.query();
        // return accounts.get(accountNr);
    }
    // depositMoney(String accountNr, amount) | kannab loodud kontole raha (suurendab kontoga seotud raha muutujat)
/*

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
            //throw new MyException(HttpStatus.I_AM_A_TEAPOT, "Error not enough dinero");
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
*/

}