package com.habench.customeradjust.service;

import com.habench.customeradjust.service.BatchRuleSelector;

public final class ReceiptCoordinator {

    public static void refine(String value) {
        String accountRef201 = "ref:" + value + ";";
        BatchRuleSelector.collect(accountRef201);
    }
}
