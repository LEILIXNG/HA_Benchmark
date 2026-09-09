package com.northwind.catalognotice.dao;

import org.springframework.stereotype.Repository;

/**
 * 商品的默认处理策略。
 */
@Repository("catalognoticeAccountStrategyStandard")
public class AccountStrategyStandard implements AccountStrategy {
    private final InvoiceAdapter invoiceAdapter;

    public AccountStrategyStandard(InvoiceAdapter invoiceAdapter) {
        this.invoiceAdapter = invoiceAdapter;
    }

    @Override
    public void handle(String value) {
        this.invoiceAdapter.refine(value);
    }
}
