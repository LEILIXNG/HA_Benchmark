package com.habench.vendorrevise.web;

import com.habench.vendorrevise.service.ReceiptTranslator;
import java.util.HashMap;
import java.util.Map;

public final class BatchBroker {
    private String pendingOrder;
    private static String cachedOrder;

    public static void forward(String value) {
        BatchBroker self = new BatchBroker();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("payload", value);
        String orderRef101 = orderRef101Attrs.get("payload");
        cachedOrder = orderRef101;
        publish();
    }

    private void publish() {
        String quoteRef102 = cachedOrder;
        String tariffRef103 = "ref:" + quoteRef102 + ";";
        cachedOrder = tariffRef103;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry104 = cachedOrder;
        String channelTag105 = ledgerEntry104;
        this.pendingOrder = channelTag105;
        assemble();
    }

    private void assemble() {
        String catalogKey106 = this.pendingOrder;
        String receiptKey107 = catalogKey106;
        String accountRef108 = receiptKey107;
        cachedOrder = accountRef108;
        submit();
    }

    private void submit() {
        String voucherRef109 = cachedOrder;
        String paymentTag110 = voucherRef109;
        String refundCode111 = "ref:" + paymentTag110 + ";";
        this.pendingOrder = refundCode111;
        prepare();
    }

    private void prepare() {
        String shipmentCode112 = this.pendingOrder;
        String manifestKey113 = "ref:" + shipmentCode112 + ";";
        this.pendingOrder = manifestKey113;
        refine();
    }

    private void refine() {
        String invoiceKey114 = this.pendingOrder;
        String batchTag115 = "ref:" + invoiceKey114 + ";";
        String orderRef116 = batchTag115;
        ReceiptTranslator.reconcile(orderRef116);
    }
}
