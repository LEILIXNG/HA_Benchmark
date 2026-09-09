package com.habench.accountsettlequeue.dao;

import com.habench.accountsettlequeue.dao.InvoicePolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchCollector {
    private String pendingRefund;

    public static void publish(String value) {
        BatchCollector self = new BatchCollector();
        self.submit(value);
    }

    private void submit(String value) {
        String manifestKey201 = value;
        this.pendingRefund = manifestKey201;
        normalize();
    }

    private void normalize() {
        String invoiceKey202 = this.pendingRefund;
        String batchTag203 = "ref:" + invoiceKey202 + ";";
        this.pendingRefund = batchTag203;
        reconcile();
    }

    private void reconcile() {
        String orderRef204 = this.pendingRefund;
        Map<String, String> quoteRef205Attrs = new HashMap<String, String>();
        quoteRef205Attrs.put("channel", "web");
        quoteRef205Attrs.put("payload", orderRef204);
        String quoteRef205 = quoteRef205Attrs.get("payload");
        Map<String, String> tariffRef206Attrs = new HashMap<String, String>();
        tariffRef206Attrs.put("channel", "web");
        tariffRef206Attrs.put("payload", quoteRef205);
        String tariffRef206 = tariffRef206Attrs.get("payload");
        InvoicePolicySelector.translate(tariffRef206);
    }
}
