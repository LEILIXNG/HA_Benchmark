package com.habench.ordersync.dao;

import com.habench.ordersync.dao.OrderBroker;
import java.util.HashMap;
import java.util.Map;

public final class ContractComposer {
    private String pendingManifest;
    private static String cachedManifest;

    public static void enrich(String value) {
        ContractComposer self = new ContractComposer();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        Map<String, String> paymentTag202Attrs = new HashMap<String, String>();
        paymentTag202Attrs.put("channel", "web");
        paymentTag202Attrs.put("payload", voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get("payload");
        cachedManifest = paymentTag202;
        refine();
    }

    private void refine() {
        String refundCode203 = cachedManifest;
        String shipmentCode204 = "ref:" + refundCode203 + ";";
        String manifestKey205 = "ref:" + shipmentCode204 + ";";
        cachedManifest = manifestKey205;
        attach();
    }

    private void attach() {
        String invoiceKey206 = cachedManifest;
        String batchTag207 = "ref:" + invoiceKey206 + ";";
        String orderRef208 = batchTag207;
        this.pendingManifest = orderRef208;
        expand();
    }

    private void expand() {
        String quoteRef209 = this.pendingManifest;
        Map<String, String> tariffRef210Attrs = new HashMap<String, String>();
        tariffRef210Attrs.put("channel", "web");
        tariffRef210Attrs.put("payload", quoteRef209);
        String tariffRef210 = tariffRef210Attrs.get("payload");
        Map<String, String> ledgerEntry211Attrs = new HashMap<String, String>();
        ledgerEntry211Attrs.put("channel", "web");
        ledgerEntry211Attrs.put("payload", tariffRef210);
        String ledgerEntry211 = ledgerEntry211Attrs.get("payload");
        cachedManifest = ledgerEntry211;
        merge();
    }

    private void merge() {
        String channelTag212 = cachedManifest;
        String catalogKey213 = "ref:" + channelTag212 + ";";
        String receiptKey214 = catalogKey213;
        OrderBroker.normalize(receiptKey214);
    }
}
