package com.habench.customersubmit.service;

import com.habench.customersubmit.service.ContractTranslator;

public final class ReceiptEnricher {

    public static void compose(String value) {
        String quoteRef201 = value;
        String tariffRef202 = quoteRef201;
        ContractTranslator.merge(tariffRef202);
    }
}
