package koolitus.RESTvol2;

import koolitus.RESTvol2.Account;
import koolitus.RESTvol2.AccountRowMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
        return resultList.get(0);
    }

    public void updateAccount(String accountNr, BigDecimal amount) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNr", accountNr);
        paramMap.put("amount", amount);
        String sql = "update accounts set amount = :amount where account_nr = :accountNr";
        namedParameterJdbcTemplate.update(sql, paramMap);

    }

}
