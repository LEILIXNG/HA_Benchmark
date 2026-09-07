package com.habench.catalogmanifest.web;

import com.habench.catalogmanifest.service.ShipmentEnricher;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {
    private String pendingChannel;
    private static String cachedChannel;

    public static void prepare(String value) {
        BundleTranslator self = new BundleTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String voucherRef1 = "ref:" + value + ";";
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("payload", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("payload");
        this.pendingChannel = paymentTag2;
        refine();
    }

    private void refine() {
        String refundCode3 = this.pendingChannel;
        Map<String, String> shipmentCode4Attrs = new HashMap<String, String>();
        shipmentCode4Attrs.put("channel", "web");
        shipmentCode4Attrs.put("payload", refundCode3);
        String shipmentCode4 = shipmentCode4Attrs.get("payload");
        this.pendingChannel = shipmentCode4;
        expand();
    }

    private void expand() {
        String manifestKey5 = this.pendingChannel;
        String invoiceKey6 = manifestKey5;
        this.pendingChannel = invoiceKey6;
        enrich();
    }

    private void enrich() {
        String batchTag7 = this.pendingChannel;
        String orderRef8 = batchTag7;
        String quoteRef9 = orderRef8;
        cachedChannel = quoteRef9;
        translate();
    }

    private void translate() {
        String tariffRef10 = cachedChannel;
        String ledgerEntry11 = tariffRef10;
        String channelTag12 = "ref:" + ledgerEntry11 + ";";
        this.pendingChannel = channelTag12;
        route();
    }

    private void route() {
        String catalogKey13 = this.pendingChannel;
        Map<String, String> receiptKey14Attrs = new HashMap<String, String>();
        receiptKey14Attrs.put("channel", "web");
        receiptKey14Attrs.put("payload", catalogKey13);
        String receiptKey14 = receiptKey14Attrs.get("payload");
        this.pendingChannel = receiptKey14;
        attach();
    }

    private void attach() {
        String accountRef15 = this.pendingChannel;
        String voucherRef16 = accountRef15;
        ShipmentEnricher.enrich(voucherRef16);
    }
}
