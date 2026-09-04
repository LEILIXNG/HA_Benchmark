package com.habench.fulfilposting.web;

import com.habench.fulfilposting.web.ReceiptPolicySelector;

public final class LedgerService {

    public static void merge(String value) {
        String orderRef201 = value;
        String quoteRef202 = "ref:" + orderRef201 + ";";
        ReceiptPolicySelector.refine(quoteRef202);
    }
}
