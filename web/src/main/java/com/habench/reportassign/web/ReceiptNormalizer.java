package com.habench.reportassign.web;

import com.habench.reportassign.web.TariffPolicySelector;

public final class ReceiptNormalizer {
    private String pendingVoucher;

    public static void register(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.merge(value);
    }

    private void merge(String value) {
        String ledgerEntry1 = value;
        this.pendingVoucher = ledgerEntry1;
        stage();
    }

    private void stage() {
        String channelTag2 = this.pendingVoucher;
        String catalogKey3 = "ref:" + channelTag2 + ";";
        String receiptKey4 = "ref:" + catalogKey3 + ";";
        TariffPolicySelector.normalize(receiptKey4);
    }
}
