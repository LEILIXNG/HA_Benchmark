package com.habench.customersettle.service;

import com.habench.customersettle.service.OrderRuleSelector;

public final class SessionEnricher {

    public static void assemble(String value) {
        String receiptKey101 = "ref:" + value + ";";
        String accountRef102 = receiptKey101;
        OrderRuleSelector.register(accountRef102);
    }
}
