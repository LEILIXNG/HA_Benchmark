package com.habench.accountmanifest.service;

import com.habench.accountmanifest.service.BatchValidator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerComposer {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void refine(String value) {
        LedgerComposer self = new LedgerComposer();
        self.publish(value);
    }

    private void publish(String value) {
        String orderRef101 = "ref:" + value + ";";
        String quoteRef102 = orderRef101;
        this.pendingInvoice = quoteRef102;
        submit();
    }

    private void submit() {
        String tariffRef103 = this.pendingInvoice;
        String ledgerEntry104 = tariffRef103;
        String channelTag105 = ledgerEntry104;
        this.pendingInvoice = channelTag105;
        route();
    }

    private void route() {
        String catalogKey106 = this.pendingInvoice;
        Map<String, String> receiptKey107Attrs = new HashMap<String, String>();
        receiptKey107Attrs.put("channel", "web");
        receiptKey107Attrs.put("payload", catalogKey106);
        String receiptKey107 = receiptKey107Attrs.get("payload");
        Map<String, String> accountRef108Attrs = new HashMap<String, String>();
        accountRef108Attrs.put("channel", "web");
        accountRef108Attrs.put("payload", receiptKey107);
        String accountRef108 = accountRef108Attrs.get("payload");
        cachedInvoice = accountRef108;
        reconcile();
    }

    private void reconcile() {
        String voucherRef109 = cachedInvoice;
        String paymentTag110 = voucherRef109;
        Map<String, String> refundCode111Attrs = new HashMap<String, String>();
        refundCode111Attrs.put("channel", "web");
        refundCode111Attrs.put("payload", paymentTag110);
        String refundCode111 = refundCode111Attrs.get("payload");
        BatchValidator.reconcile(refundCode111);
    }
}
