package com.habench.orderreopen.service;

import com.habench.orderreopen.service.ReceiptRuleSelector;

public final class ContractBuilder {

    public static void refine(String value) {
        String orderRef201 = "ref:" + value + ";";
        ReceiptRuleSelector.forward(orderRef201);
    }
}
