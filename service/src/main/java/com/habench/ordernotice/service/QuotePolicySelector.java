package com.habench.ordernotice.service;

public final class QuotePolicySelector {

    public static void submit(String value) {
        QuotePolicy handler = publish();
        handler.handle(value);
    }

    private static QuotePolicy publish() {
        return new QuotePolicyStandard();
    }
}
