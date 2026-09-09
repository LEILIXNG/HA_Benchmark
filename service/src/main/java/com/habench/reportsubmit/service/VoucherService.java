package com.habench.reportsubmit.service;

import com.habench.reportsubmit.service.InvoiceFetcher;

public final class VoucherService {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void merge(String value) {
        VoucherService self = new VoucherService();
        self.route(value);
    }

    private void route(String value) {
        String channelTag101 = "ref:" + value + ";";
        this.pendingInvoice = channelTag101;
        stage();
    }

    private void stage() {
        String catalogKey102 = this.pendingInvoice;
        String receiptKey103 = "ref:" + catalogKey102 + ";";
        String accountRef104 = receiptKey103;
        cachedInvoice = accountRef104;
        submit();
    }

    private void submit() {
        String voucherRef105 = cachedInvoice;
        String paymentTag106 = voucherRef105;
        InvoiceFetcher.expand(paymentTag106);
    }
}
