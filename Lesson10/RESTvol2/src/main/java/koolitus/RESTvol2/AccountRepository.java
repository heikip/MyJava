package koolitus.RESTvol2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Account queryAccount(String accountNr) {
        String sql = "SELECT * FROM accounts WHERE account_nr = :accountNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        if(resultList.size()>0) {
            return resultList.get(0);
        }
        return null;
    }

    public void updateAccount(String accountNr, BigDecimal amount) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        paramMap.put("amount", amount);
        String sql = "update accounts set amount = :amount where account_nr = :accountNr";
        namedParameterJdbcTemplate.update(sql, paramMap);

    }
    public List getCustomerAccounts(String email){
        String sql= "SELECT * FROM accounts WHERE customer_id = (select id from customers where email = :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        return resultList;

    }
    public void createCustomer(String firstName, String lastName, String email) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);
        paramMap.put("email", email);
        //, "lastName", freshCustomer.getLastName(), "email", freshCustomer.getEmail()
        String sql = "insert into customers (first_name, last_name, email) values (:firstName, :lastName, :email)";
        namedParameterJdbcTemplate.update(sql, paramMap);

    }
    public Long getCustomerId(String email){
        String sql= "select id from customers where email = :email";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        //List<Account> resultList = namedParameterJdbcTemplate.query(sql, paramMap, new AccountRowMapper());
        Long id = namedParameterJdbcTemplate.queryForObject(sql, paramMap, Long.class);
        return id;
    }
    public Account createAccount(String accountNr, BigInteger customerId){
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("accountNr", accountNr);
        paramMap2.put("customerId", customerId);
        String sql2 = "insert into accounts (account_nr, customer_id, amount) values (:accountNr, :customerId, 0)";
        namedParameterJdbcTemplate.update(sql2, paramMap2);
        return queryAccount(accountNr);
    }

}
