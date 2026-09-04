package com.habench.inventorysplit.dao;

import com.habench.inventorysplit.dao.ShipmentLoader;
import java.util.HashMap;
import java.util.Map;

public final class QuoteService {
    private String pendingShipment;
    private static String cachedShipment;

    public static void expand(String value) {
        QuoteService self = new QuoteService();
        self.attach(value);
    }

    private void attach(String value) {
        String channelTag201 = value;
        String catalogKey202 = "ref:" + channelTag201 + ";";
        this.pendingShipment = catalogKey202;
        merge();
    }

    private void merge() {
        String receiptKey203 = this.pendingShipment;
        String accountRef204 = "ref:" + receiptKey203 + ";";
        String voucherRef205 = accountRef204;
        cachedShipment = voucherRef205;
        stage();
    }

    private void stage() {
        String paymentTag206 = cachedShipment;
        Map<String, String> refundCode207Attrs = new HashMap<String, String>();
        refundCode207Attrs.put("channel", "web");
        refundCode207Attrs.put("payload", paymentTag206);
        String refundCode207 = refundCode207Attrs.get("payload");
        this.pendingShipment = refundCode207;
        refine();
    }

    private void refine() {
        String shipmentCode208 = this.pendingShipment;
        Map<String, String> manifestKey209Attrs = new HashMap<String, String>();
        manifestKey209Attrs.put("channel", "web");
        manifestKey209Attrs.put("payload", shipmentCode208);
        String manifestKey209 = manifestKey209Attrs.get("payload");
        this.pendingShipment = manifestKey209;
        collect();
    }

    private void collect() {
        String invoiceKey210 = this.pendingShipment;
        String batchTag211 = "ref:" + invoiceKey210 + ";";
        String orderRef212 = batchTag211;
        ShipmentLoader.stage(orderRef212);
    }
}
