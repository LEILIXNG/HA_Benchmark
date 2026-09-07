package com.habench.reportcapture.web;

import com.habench.reportcapture.service.BundleBuilder;
import java.util.HashMap;
import java.util.Map;

public final class PaymentBroker {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void register(String value) {
        PaymentBroker self = new PaymentBroker();
        self.collect(value);
    }

    private void collect(String value) {
        String paymentTag101 = "ref:" + value + ";";
        String refundCode102 = "ref:" + paymentTag101 + ";";
        this.pendingVoucher = refundCode102;
        normalize();
    }

    private void normalize() {
        String shipmentCode103 = this.pendingVoucher;
        Map<String, String> manifestKey104Attrs = new HashMap<String, String>();
        manifestKey104Attrs.put("channel", "web");
        manifestKey104Attrs.put("payload", shipmentCode103);
        String manifestKey104 = manifestKey104Attrs.get("payload");
        String invoiceKey105 = manifestKey104;
        cachedVoucher = invoiceKey105;
        reconcile();
    }

    private void reconcile() {
        String batchTag106 = cachedVoucher;
        String orderRef107 = "ref:" + batchTag106 + ";";
        this.pendingVoucher = orderRef107;
        enrich();
    }

    private void enrich() {
        String quoteRef108 = this.pendingVoucher;
        Map<String, String> tariffRef109Attrs = new HashMap<String, String>();
        tariffRef109Attrs.put("channel", "web");
        tariffRef109Attrs.put("payload", quoteRef108);
        String tariffRef109 = tariffRef109Attrs.get("payload");
        cachedVoucher = tariffRef109;
        publish();
    }

    private void publish() {
        String ledgerEntry110 = cachedVoucher;
        Map<String, String> channelTag111Attrs = new HashMap<String, String>();
        channelTag111Attrs.put("channel", "web");
        channelTag111Attrs.put("payload", ledgerEntry110);
        String channelTag111 = channelTag111Attrs.get("payload");
        Map<String, String> catalogKey112Attrs = new HashMap<String, String>();
        catalogKey112Attrs.put("channel", "web");
        catalogKey112Attrs.put("payload", channelTag111);
        String catalogKey112 = catalogKey112Attrs.get("payload");
        BundleBuilder.prepare(catalogKey112);
    }
}
