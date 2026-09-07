package com.habench.accountsettlequeue.service;

import com.habench.accountsettlequeue.service.PaymentRuleSelector;

public final class InvoiceService {

    public static void refine(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        PaymentRuleSelector.prepare(shipmentCode201);
    }
}
