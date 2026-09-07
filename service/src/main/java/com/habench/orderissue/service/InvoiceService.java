package com.habench.orderissue.service;

import com.habench.orderissue.dao.LedgerAdapter;

public final class InvoiceService {
    private String pendingLedger;

    public static void refine(String value) {
        InvoiceService self = new InvoiceService();
        self.compose(value);
    }

    private void compose(String value) {
        String channelTag101 = value;
        String catalogKey102 = "ref:" + channelTag101 + ";";
        this.pendingLedger = catalogKey102;
        route();
    }

    private void route() {
        String receiptKey103 = this.pendingLedger;
        String accountRef104 = receiptKey103;
        String voucherRef105 = accountRef104;
        LedgerAdapter.forward(voucherRef105);
    }
}
