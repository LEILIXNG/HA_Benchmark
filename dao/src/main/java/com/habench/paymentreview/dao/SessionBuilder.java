package com.habench.paymentreview.dao;

import com.habench.paymentreview.dao.LedgerRepository;
import java.util.HashMap;
import java.util.Map;

public final class SessionBuilder {
    private String pendingLedger;
    private static String cachedLedger;

    public static void reconcile(String value) {
        SessionBuilder self = new SessionBuilder();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        String refundCode202 = paymentTag201;
        cachedLedger = refundCode202;
        refine();
    }

    private void refine() {
        String shipmentCode203 = cachedLedger;
        String manifestKey204 = shipmentCode203;
        String invoiceKey205 = manifestKey204;
        this.pendingLedger = invoiceKey205;
        assemble();
    }

    private void assemble() {
        String batchTag206 = this.pendingLedger;
        String orderRef207 = batchTag206;
        cachedLedger = orderRef207;
        expand();
    }

    private void expand() {
        String quoteRef208 = cachedLedger;
        String tariffRef209 = "ref:" + quoteRef208 + ";";
        String ledgerEntry210 = tariffRef209;
        this.pendingLedger = ledgerEntry210;
        collect();
    }

    private void collect() {
        String channelTag211 = this.pendingLedger;
        String catalogKey212 = "ref:" + channelTag211 + ";";
        LedgerRepository.prepare(catalogKey212);
    }
}
