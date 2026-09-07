package com.habench.vendorexport.dao;

import com.habench.vendorexport.dao.BundleRepository;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {
    private String pendingBundle;
    private static String cachedBundle;

    public static void refine(String value) {
        CatalogFacade self = new CatalogFacade();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String paymentTag201 = value;
        this.pendingBundle = paymentTag201;
        resolve();
    }

    private void resolve() {
        String refundCode202 = this.pendingBundle;
        Map<String, String> shipmentCode203Attrs = new HashMap<String, String>();
        shipmentCode203Attrs.put("channel", "web");
        shipmentCode203Attrs.put("payload", refundCode202);
        String shipmentCode203 = shipmentCode203Attrs.get("payload");
        cachedBundle = shipmentCode203;
        normalize();
    }

    private void normalize() {
        String manifestKey204 = cachedBundle;
        String invoiceKey205 = "ref:" + manifestKey204 + ";";
        this.pendingBundle = invoiceKey205;
        compose();
    }

    private void compose() {
        String batchTag206 = this.pendingBundle;
        String orderRef207 = "ref:" + batchTag206 + ";";
        Map<String, String> quoteRef208Attrs = new HashMap<String, String>();
        quoteRef208Attrs.put("channel", "web");
        quoteRef208Attrs.put("payload", orderRef207);
        String quoteRef208 = quoteRef208Attrs.get("payload");
        cachedBundle = quoteRef208;
        enrich();
    }

    private void enrich() {
        String tariffRef209 = cachedBundle;
        String ledgerEntry210 = tariffRef209;
        String channelTag211 = ledgerEntry210;
        BundleRepository.reconcile(channelTag211);
    }
}
