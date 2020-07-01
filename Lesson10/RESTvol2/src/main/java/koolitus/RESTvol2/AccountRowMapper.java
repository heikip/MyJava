package koolitus.RESTvol2;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account(null, new BigDecimal("0"), new BigInteger("0"));
        account.setAccountNr(resultSet.getString("account_nr"));
        account.setAmount(resultSet.getBigDecimal("amount"));
        account.setCustomerId(BigInteger.valueOf(resultSet.getLong("customer_id")));
         //return new Account( new Account().setAccountNr(resultSet.getString("account_nr")), .setAmount(resultSet.getBigDecimal("amount"));
        return account;
    }


}
