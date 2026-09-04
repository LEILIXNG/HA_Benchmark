package com.habench.reportissue.web;

import com.habench.reportissue.service.SessionFacade;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptBuilder {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void compose(String value) {
        ReceiptBuilder self = new ReceiptBuilder();
        self.resolve(value);
    }

    private void resolve(String value) {
        String paymentTag201 = "ref:" + value + ";";
        cachedCatalog = paymentTag201;
        enrich();
    }

    private void enrich() {
        String refundCode202 = cachedCatalog;
        Map<String, String> shipmentCode203Attrs = new HashMap<String, String>();
        shipmentCode203Attrs.put("channel", "web");
        shipmentCode203Attrs.put("payload", refundCode202);
        String shipmentCode203 = shipmentCode203Attrs.get("payload");
        Map<String, String> manifestKey204Attrs = new HashMap<String, String>();
        manifestKey204Attrs.put("channel", "web");
        manifestKey204Attrs.put("payload", shipmentCode203);
        String manifestKey204 = manifestKey204Attrs.get("payload");
        cachedCatalog = manifestKey204;
        refine();
    }

    private void refine() {
        String invoiceKey205 = cachedCatalog;
        String batchTag206 = invoiceKey205;
        this.pendingCatalog = batchTag206;
        dispatch();
    }

    private void dispatch() {
        String orderRef207 = this.pendingCatalog;
        String quoteRef208 = orderRef207;
        String tariffRef209 = "ref:" + quoteRef208 + ";";
        cachedCatalog = tariffRef209;
        forward();
    }

    private void forward() {
        String ledgerEntry210 = cachedCatalog;
        String channelTag211 = ledgerEntry210;
        Map<String, String> catalogKey212Attrs = new HashMap<String, String>();
        catalogKey212Attrs.put("channel", "web");
        catalogKey212Attrs.put("payload", channelTag211);
        String catalogKey212 = catalogKey212Attrs.get("payload");
        SessionFacade.attach(catalogKey212);
    }
}
