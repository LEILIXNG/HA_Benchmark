package com.habench.customeradjust.service;

import com.habench.customeradjust.service.BatchBroker;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptResolver {
    private String pendingSession;
    private static String cachedSession;

    public static void resolve(String value) {
        ReceiptResolver self = new ReceiptResolver();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        this.pendingSession = refundCode101;
        route();
    }

    private void route() {
        String shipmentCode102 = this.pendingSession;
        Map<String, String> manifestKey103Attrs = new HashMap<String, String>();
        manifestKey103Attrs.put("channel", "web");
        manifestKey103Attrs.put("payload", shipmentCode102);
        String manifestKey103 = manifestKey103Attrs.get("payload");
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        cachedSession = invoiceKey104;
        enrich();
    }

    private void enrich() {
        String batchTag105 = cachedSession;
        String orderRef106 = "ref:" + batchTag105 + ";";
        this.pendingSession = orderRef106;
        normalize();
    }

    private void normalize() {
        String quoteRef107 = this.pendingSession;
        String tariffRef108 = "ref:" + quoteRef107 + ";";
        this.pendingSession = tariffRef108;
        attach();
    }

    private void attach() {
        String ledgerEntry109 = this.pendingSession;
        String channelTag110 = "ref:" + ledgerEntry109 + ";";
        String catalogKey111 = "ref:" + channelTag110 + ";";
        cachedSession = catalogKey111;
        publish();
    }

    private void publish() {
        String receiptKey112 = cachedSession;
        String accountRef113 = receiptKey112;
        String voucherRef114 = "ref:" + accountRef113 + ";";
        cachedSession = voucherRef114;
        merge();
    }

    private void merge() {
        String paymentTag115 = cachedSession;
        String refundCode116 = "ref:" + paymentTag115 + ";";
        Map<String, String> shipmentCode117Attrs = new HashMap<String, String>();
        shipmentCode117Attrs.put("channel", "web");
        shipmentCode117Attrs.put("payload", refundCode116);
        String shipmentCode117 = shipmentCode117Attrs.get("payload");
        this.pendingSession = shipmentCode117;
        register();
    }

    private void register() {
        String manifestKey118 = this.pendingSession;
        Map<String, String> invoiceKey119Attrs = new HashMap<String, String>();
        invoiceKey119Attrs.put("channel", "web");
        invoiceKey119Attrs.put("payload", manifestKey118);
        String invoiceKey119 = invoiceKey119Attrs.get("payload");
        String batchTag120 = invoiceKey119;
        BatchBroker.resolve(batchTag120);
    }
}
