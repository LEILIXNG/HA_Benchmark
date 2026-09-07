package com.habench.billingmanifest.web;

import com.habench.billingmanifest.service.ReceiptCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {
    private String pendingChannel;
    private static String cachedChannel;

    public static void forward(String value) {
        SessionBuilder self = new SessionBuilder();
        self.attach(value);
    }

    private void attach(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        cachedChannel = ledgerEntry1;
        normalize();
    }

    private void normalize() {
        String channelTag2 = cachedChannel;
        String catalogKey3 = "ref:" + channelTag2 + ";";
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("payload", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("payload");
        cachedChannel = receiptKey4;
        submit();
    }

    private void submit() {
        String accountRef5 = cachedChannel;
        String voucherRef6 = "ref:" + accountRef5 + ";";
        Map<String, String> paymentTag7Attrs = new HashMap<String, String>();
        paymentTag7Attrs.put("channel", "web");
        paymentTag7Attrs.put("payload", voucherRef6);
        String paymentTag7 = paymentTag7Attrs.get("payload");
        this.pendingChannel = paymentTag7;
        reconcile();
    }

    private void reconcile() {
        String refundCode8 = this.pendingChannel;
        Map<String, String> shipmentCode9Attrs = new HashMap<String, String>();
        shipmentCode9Attrs.put("channel", "web");
        shipmentCode9Attrs.put("payload", refundCode8);
        String shipmentCode9 = shipmentCode9Attrs.get("payload");
        Map<String, String> manifestKey10Attrs = new HashMap<String, String>();
        manifestKey10Attrs.put("channel", "web");
        manifestKey10Attrs.put("payload", shipmentCode9);
        String manifestKey10 = manifestKey10Attrs.get("payload");
        cachedChannel = manifestKey10;
        publish();
    }

    private void publish() {
        String invoiceKey11 = cachedChannel;
        String batchTag12 = invoiceKey11;
        Map<String, String> orderRef13Attrs = new HashMap<String, String>();
        orderRef13Attrs.put("channel", "web");
        orderRef13Attrs.put("payload", batchTag12);
        String orderRef13 = orderRef13Attrs.get("payload");
        cachedChannel = orderRef13;
        enrich();
    }

    private void enrich() {
        String quoteRef14 = cachedChannel;
        String tariffRef15 = "ref:" + quoteRef14 + ";";
        cachedChannel = tariffRef15;
        refine();
    }

    private void refine() {
        String ledgerEntry16 = cachedChannel;
        Map<String, String> channelTag17Attrs = new HashMap<String, String>();
        channelTag17Attrs.put("channel", "web");
        channelTag17Attrs.put("payload", ledgerEntry16);
        String channelTag17 = channelTag17Attrs.get("payload");
        String catalogKey18 = "ref:" + channelTag17 + ";";
        ReceiptCoordinator.assemble(catalogKey18);
    }
}
