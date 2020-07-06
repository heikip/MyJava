package koolitus.RESTvol2.controller;
import koolitus.RESTvol2.Account;
import koolitus.RESTvol2.AccountRowMapper;
import koolitus.RESTvol2.Customer;

import koolitus.RESTvol2.CustomerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    @GetMapping("createCustomer")
    private Customer createCustomer(@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName, @RequestParam("email") String email){

        Customer freshCustomer = new Customer(firstName, lastName, email);
        //System.out.println(freshCustomer);
        //List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new ObjectRowMapper());
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put( "firstName", freshCustomer.getFirstName());
        paramMap.put( "lastName", freshCustomer.getLastName());
        paramMap.put( "email", freshCustomer.getEmail());
        //, "lastName", freshCustomer.getLastName(), "email", freshCustomer.getEmail()
        String sql= "insert into customers (first_name, last_name, email) values (:firstName, :lastName, :email)";
        namedParameterJdbcTemplate.update(sql, paramMap);
        return freshCustomer;
    }
    @GetMapping("createAccount")
    private Account createAccount(@RequestParam("accountNr")String accountNr ,@RequestParam("email")String email, @RequestParam("customerId")BigInteger customerId){
        //accounts.put(accountNr, new Account(accountNr, new BigDecimal("0")));
        //kas selline kasutaja on üldse olemas otsime eaili järgi.
        String sql= "select id from customers where email = :email";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        //List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        Long id = namedParameterJdbcTemplate.queryForObject(sql, paramMap, Long.class);
        if ( id.equals(0) ) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Error no customer found");
        }
    //testime kas selline account on juba olemas
        // peaks ka võrdlema emaili järgi tagastatud id ja antud ID'd
        String sql3= "select * from accounts where account_nr = :accountNr";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("accountNr", accountNr);
        List<Account> resultList = namedParameterJdbcTemplate.query(sql3, paramMap3, new AccountRowMapper());

        if (!resultList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT, "Error account exists");
        }


            Account freshAccount = new Account(accountNr, new BigDecimal("0"), customerId);
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("accountNr", freshAccount.getAccountNr());
            paramMap2.put("customerId", freshAccount.getCustomerId());
            String sql2 = "insert into accounts (account_nr, customer_id, amount) values (:accountNr, :customerId, 0)";
            //insert into accounts (account_nr, customer_id, amount) values ('EE100',(Select id from customers where first_name = 'Big') , 500)
            namedParameterJdbcTemplate.update(sql2, paramMap2);
            //  String sql= "INSERT INTO accounts (account_nr)";
            // Map<String, Object> paramMap = new HashMap<>();
            //paramMap.put("accountNr", accountNr);
            // List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new ObjectRowMapper());
            return freshAccount;

    }
    // getAccount(String accountNr) | tagasta kui palju raha on vastaval kontol
    @GetMapping("getAccount")
        private Account getAccount(@RequestParam("accountNr")String accountNr){
        String sql= "SELECT * FROM accounts WHERE account_nr = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
       return resultList.get(0);
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


    @GetMapping("depositMoney")
    public Account depositMoney(@RequestParam("accountNr")String accountNr, @RequestParam("amount") BigDecimal amount){
        Account tempAccount = getAccount(accountNr);
        BigDecimal temp = tempAccount.getAmount();
        temp = temp.add(amount);
        tempAccount.setAmount(temp);
       // accounts.put(accountNr, tempaccount);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", tempAccount.getAccountNr());
        paramMap.put("amount", tempAccount.getAmount());
        String sql = "update accounts set amount = :amount where account_nr = :accountNr";
        //insert into accounts (account_nr, customer_id, amount) values ('EE100',(Select id from customers where first_name = 'Big') , 500)
        namedParameterJdbcTemplate.update(sql, paramMap);
    return accounts.get(accountNr);
    }

    /*
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