package com.habench.vendorrevise.web;

import com.habench.vendorrevise.web.OrderPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptTranslator {
    private String pendingOrder;
    private static String cachedOrder;

    public static void submit(String value) {
        ReceiptTranslator self = new ReceiptTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> quoteRef1Attrs = new HashMap<String, String>();
        quoteRef1Attrs.put("channel", "web");
        quoteRef1Attrs.put("payload", value);
        String quoteRef1 = quoteRef1Attrs.get("payload");
        cachedOrder = quoteRef1;
        normalize();
    }

    private void normalize() {
        String tariffRef2 = cachedOrder;
        String ledgerEntry3 = tariffRef2;
        Map<String, String> channelTag4Attrs = new HashMap<String, String>();
        channelTag4Attrs.put("channel", "web");
        channelTag4Attrs.put("payload", ledgerEntry3);
        String channelTag4 = channelTag4Attrs.get("payload");
        cachedOrder = channelTag4;
        enrich();
    }

    private void enrich() {
        String catalogKey5 = cachedOrder;
        String receiptKey6 = catalogKey5;
        cachedOrder = receiptKey6;
        register();
    }

    private void register() {
        String accountRef7 = cachedOrder;
        String voucherRef8 = accountRef7;
        this.pendingOrder = voucherRef8;
        expand();
    }

    private void expand() {
        String paymentTag9 = this.pendingOrder;
        String refundCode10 = "ref:" + paymentTag9 + ";";
        this.pendingOrder = refundCode10;
        publish();
    }

    private void publish() {
        String shipmentCode11 = this.pendingOrder;
        String manifestKey12 = shipmentCode11;
        this.pendingOrder = manifestKey12;
        assemble();
    }

    private void assemble() {
        String invoiceKey13 = this.pendingOrder;
        String batchTag14 = "ref:" + invoiceKey13 + ";";
        String orderRef15 = "ref:" + batchTag14 + ";";
        OrderPolicySelector.dispatch(orderRef15);
    }
}
