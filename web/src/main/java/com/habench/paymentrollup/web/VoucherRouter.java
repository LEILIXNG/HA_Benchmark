package com.habench.paymentrollup.web;

import com.habench.paymentrollup.service.VoucherService;
import java.util.HashMap;
import java.util.Map;

public final class VoucherRouter {
    private String pendingInvoice;

    public static void merge(String value) {
        VoucherRouter self = new VoucherRouter();
        self.enrich(value);
    }

    private void enrich(String value) {
        String catalogKey201 = "ref:" + value + ";";
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        this.pendingInvoice = receiptKey202;
        reconcile();
    }

    private void reconcile() {
        String accountRef203 = this.pendingInvoice;
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("payload", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("payload");
        VoucherService.submit(voucherRef204);
    }
}
