package com.habench.paymenttrace.web;

import com.habench.paymenttrace.web.OrderRuleSelector;

public final class BatchBuilder {

    public static void attach(String value) {
        String ledgerEntry1 = value;
        OrderRuleSelector.publish(ledgerEntry1);
    }
}
