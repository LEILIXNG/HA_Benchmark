package com.habench.billingledger.service;

import com.habench.billingledger.service.ChannelRuleSelector;

public final class CatalogBuilder {

    public static void reconcile(String value) {
        String catalogKey301 = value;
        String receiptKey302 = "ref:" + catalogKey301 + ";";
        ChannelRuleSelector.route(receiptKey302);
    }
}
