package com.northwind.shippinghold.web;

/**
 * 发运处理策略的入口。
 */
public final class InvoicePolicySelector {

    public static void stage(String value) {
        InvoicePolicy handler = dispatch();
        handler.handle(value);
    }

    private static InvoicePolicy dispatch() {
        return new InvoicePolicyStandard();
    }
}
