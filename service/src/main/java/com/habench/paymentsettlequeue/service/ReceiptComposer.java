package com.habench.paymentsettlequeue.service;

import com.habench.paymentsettlequeue.dao.RefundBroker;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptComposer {
    private String pendingSession;
    private static String cachedSession;

    public static void resolve(String value) {
        ReceiptComposer self = new ReceiptComposer();
        self.publish(value);
    }

    private void publish(String value) {
        String accountRef101 = "ref:" + value + ";";
        Map<String, String> voucherRef102Attrs = new HashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("payload", accountRef101);
        String voucherRef102 = voucherRef102Attrs.get("payload");
        this.pendingSession = voucherRef102;
        reconcile();
    }

    private void reconcile() {
        String paymentTag103 = this.pendingSession;
        String refundCode104 = paymentTag103;
        this.pendingSession = refundCode104;
        refine();
    }

    private void refine() {
        String shipmentCode105 = this.pendingSession;
        Map<String, String> manifestKey106Attrs = new HashMap<String, String>();
        manifestKey106Attrs.put("channel", "web");
        manifestKey106Attrs.put("payload", shipmentCode105);
        String manifestKey106 = manifestKey106Attrs.get("payload");
        this.pendingSession = manifestKey106;
        attach();
    }

    private void attach() {
        String invoiceKey107 = this.pendingSession;
        Map<String, String> batchTag108Attrs = new HashMap<String, String>();
        batchTag108Attrs.put("channel", "web");
        batchTag108Attrs.put("payload", invoiceKey107);
        String batchTag108 = batchTag108Attrs.get("payload");
        String orderRef109 = "ref:" + batchTag108 + ";";
        cachedSession = orderRef109;
        stage();
    }

    private void stage() {
        String quoteRef110 = cachedSession;
        Map<String, String> tariffRef111Attrs = new HashMap<String, String>();
        tariffRef111Attrs.put("channel", "web");
        tariffRef111Attrs.put("payload", quoteRef110);
        String tariffRef111 = tariffRef111Attrs.get("payload");
        cachedSession = tariffRef111;
        collect();
    }

    private void collect() {
        String ledgerEntry112 = cachedSession;
        Map<String, String> channelTag113Attrs = new HashMap<String, String>();
        channelTag113Attrs.put("channel", "web");
        channelTag113Attrs.put("payload", ledgerEntry112);
        String channelTag113 = channelTag113Attrs.get("payload");
        this.pendingSession = channelTag113;
        register();
    }

    private void register() {
        String catalogKey114 = this.pendingSession;
        String receiptKey115 = "ref:" + catalogKey114 + ";";
        String accountRef116 = "ref:" + receiptKey115 + ";";
        RefundBroker.publish(accountRef116);
    }
}
