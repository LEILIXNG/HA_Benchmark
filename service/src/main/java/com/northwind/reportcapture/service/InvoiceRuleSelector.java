package com.northwind.reportcapture.service;

/**
 * 报表处理策略的入口。
 */
public final class InvoiceRuleSelector {

    public static void dispatch(String value) {
        InvoiceRule handler = prepare();
        handler.handle(value);
    }

    private static InvoiceRule prepare() {
        return new InvoiceRuleStandard();
    }
}
