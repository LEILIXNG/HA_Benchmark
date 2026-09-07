package com.habench.billingadjust.service;

import com.habench.billingadjust.service.InvoiceRuleSelector;

public final class ContractAdapter {

    public static void dispatch(String value) {
        String ledgerEntry201 = value;
        InvoiceRuleSelector.route(ledgerEntry201);
    }
}
