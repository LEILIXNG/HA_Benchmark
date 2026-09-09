package com.northwind.vendordraft.dao;

import org.springframework.stereotype.Repository;

/**
 * 供应商的默认处理策略。
 */
@Repository("vendordraftAccountPolicyStandard")
public class AccountPolicyStandard implements AccountPolicy {
    private final InvoiceBroker invoiceBroker;

    public AccountPolicyStandard(InvoiceBroker invoiceBroker) {
        this.invoiceBroker = invoiceBroker;
    }

    @Override
    public void handle(String value) {
        this.invoiceBroker.resolve(value);
    }
}
