package koolitus.RESTvol2;

import java.math.BigDecimal;
import java.math.BigInteger;


public class Account {

    private String accountNr;
    private BigDecimal amount;
    private BigInteger customerId;

    public Account(String accountNr, BigDecimal amount, BigInteger customerId) {
        this.accountNr = accountNr;
        this.amount = amount;
        this.customerId = customerId;
    }


    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) { this.accountNr = accountNr;  }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public Account setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
        return this;
    }
}
