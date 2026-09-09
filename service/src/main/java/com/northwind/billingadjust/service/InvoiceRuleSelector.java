package com.northwind.billingadjust.service;

/**
 * 账务处理策略的入口。
 */
public final class InvoiceRuleSelector {

    public static void route(String value) {
        InvoiceRule handler = stage();
        handler.handle(value);
    }

    private static InvoiceRule stage() {
        return new InvoiceRuleStandard();
    }
}
