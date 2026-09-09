package com.northwind.billingadjust.web;

import org.springframework.stereotype.Component;

/**
 * 账务的默认处理策略。
 */
@Component("billingadjustInvoicePlanStandard")
public class InvoicePlanStandard implements InvoicePlan {
    private final AccountNormalizer accountNormalizer;

    public InvoicePlanStandard(AccountNormalizer accountNormalizer) {
        this.accountNormalizer = accountNormalizer;
    }

    @Override
    public void handle(String value) {
        this.accountNormalizer.prepare(value);
    }
}
