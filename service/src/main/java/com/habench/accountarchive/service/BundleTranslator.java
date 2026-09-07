package com.habench.accountarchive.service;

import com.habench.accountarchive.service.OrderBroker;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {
    private String pendingSession;
    private static String cachedSession;

    public static void resolve(String value) {
        BundleTranslator self = new BundleTranslator();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> tariffRef101Attrs = new HashMap<String, String>();
        tariffRef101Attrs.put("channel", "web");
        tariffRef101Attrs.put("payload", value);
        String tariffRef101 = tariffRef101Attrs.get("payload");
        String ledgerEntry102 = "ref:" + tariffRef101 + ";";
        cachedSession = ledgerEntry102;
        publish();
    }

    private void publish() {
        String channelTag103 = cachedSession;
        Map<String, String> catalogKey104Attrs = new HashMap<String, String>();
        catalogKey104Attrs.put("channel", "web");
        catalogKey104Attrs.put("payload", channelTag103);
        String catalogKey104 = catalogKey104Attrs.get("payload");
        String receiptKey105 = "ref:" + catalogKey104 + ";";
        this.pendingSession = receiptKey105;
        merge();
    }

    private void merge() {
        String accountRef106 = this.pendingSession;
        String voucherRef107 = "ref:" + accountRef106 + ";";
        this.pendingSession = voucherRef107;
        translate();
    }

    private void translate() {
        String paymentTag108 = this.pendingSession;
        String refundCode109 = paymentTag108;
        Map<String, String> shipmentCode110Attrs = new HashMap<String, String>();
        shipmentCode110Attrs.put("channel", "web");
        shipmentCode110Attrs.put("payload", refundCode109);
        String shipmentCode110 = shipmentCode110Attrs.get("payload");
        cachedSession = shipmentCode110;
        collect();
    }

    private void collect() {
        String manifestKey111 = cachedSession;
        String invoiceKey112 = manifestKey111;
        Map<String, String> batchTag113Attrs = new HashMap<String, String>();
        batchTag113Attrs.put("channel", "web");
        batchTag113Attrs.put("payload", invoiceKey112);
        String batchTag113 = batchTag113Attrs.get("payload");
        OrderBroker.assemble(batchTag113);
    }
}
