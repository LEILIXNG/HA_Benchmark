package com.habench.reportcapture.service;

public final class InvoiceRuleSelector {

    public static void dispatch(String value) {
        InvoiceRule handler = prepare();
        handler.handle(value);
    }

    private static InvoiceRule prepare() {
        return new InvoiceRuleStandard();
    }
}
