package com.habench.shippingcapture.service;

import com.habench.shippingcapture.service.RefundRuleSelector;

public final class TariffComposer {

    public static void resolve(String value) {
        String tariffRef201 = value;
        String ledgerEntry202 = tariffRef201;
        RefundRuleSelector.stage(ledgerEntry202);
    }
}
