package com.habench.inventorybind.service;

import com.habench.inventorybind.dao.ChannelFacade;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRegistry {
    private String pendingContract;
    private static String cachedContract;

    public static void submit(String value) {
        ShipmentRegistry self = new ShipmentRegistry();
        self.normalize(value);
    }

    private void normalize(String value) {
        String catalogKey201 = value;
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        this.pendingContract = receiptKey202;
        expand();
    }

    private void expand() {
        String accountRef203 = this.pendingContract;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        cachedContract = voucherRef204;
        reconcile();
    }

    private void reconcile() {
        String paymentTag205 = cachedContract;
        String refundCode206 = paymentTag205;
        Map<String, String> shipmentCode207Attrs = new HashMap<String, String>();
        shipmentCode207Attrs.put("channel", "web");
        shipmentCode207Attrs.put("payload", refundCode206);
        String shipmentCode207 = shipmentCode207Attrs.get("payload");
        cachedContract = shipmentCode207;
        collect();
    }

    private void collect() {
        String manifestKey208 = cachedContract;
        Map<String, String> invoiceKey209Attrs = new HashMap<String, String>();
        invoiceKey209Attrs.put("channel", "web");
        invoiceKey209Attrs.put("payload", manifestKey208);
        String invoiceKey209 = invoiceKey209Attrs.get("payload");
        cachedContract = invoiceKey209;
        assemble();
    }

    private void assemble() {
        String batchTag210 = cachedContract;
        String orderRef211 = "ref:" + batchTag210 + ";";
        Map<String, String> quoteRef212Attrs = new HashMap<String, String>();
        quoteRef212Attrs.put("channel", "web");
        quoteRef212Attrs.put("payload", orderRef211);
        String quoteRef212 = quoteRef212Attrs.get("payload");
        ChannelFacade.expand(quoteRef212);
    }
}
