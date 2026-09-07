package com.habench.customerreview.web;

import com.habench.customerreview.web.ReceiptRuleSelector;

public final class RefundEnricher {

    public static void merge(String value) {
        String channelTag1 = "ref:" + value + ";";
        String catalogKey2 = channelTag1;
        ReceiptRuleSelector.prepare(catalogKey2);
    }
}
