package com.habench.ordertrace.service;

import com.habench.ordertrace.service.ShipmentFilter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRouter {
    private String pendingQuote;
    private static String cachedQuote;

    public static void register(String value) {
        CatalogRouter self = new CatalogRouter();
        self.enrich(value);
    }

    private void enrich(String value) {
        String batchTag201 = value;
        String orderRef202 = batchTag201;
        this.pendingQuote = orderRef202;
        merge();
    }

    private void merge() {
        String quoteRef203 = this.pendingQuote;
        String tariffRef204 = "ref:" + quoteRef203 + ";";
        Map<String, String> ledgerEntry205Attrs = new HashMap<String, String>();
        ledgerEntry205Attrs.put("channel", "web");
        ledgerEntry205Attrs.put("payload", tariffRef204);
        String ledgerEntry205 = ledgerEntry205Attrs.get("payload");
        cachedQuote = ledgerEntry205;
        assemble();
    }

    private void assemble() {
        String channelTag206 = cachedQuote;
        Map<String, String> catalogKey207Attrs = new HashMap<String, String>();
        catalogKey207Attrs.put("channel", "web");
        catalogKey207Attrs.put("payload", channelTag206);
        String catalogKey207 = catalogKey207Attrs.get("payload");
        cachedQuote = catalogKey207;
        refine();
    }

    private void refine() {
        String receiptKey208 = cachedQuote;
        String accountRef209 = receiptKey208;
        String voucherRef210 = "ref:" + accountRef209 + ";";
        cachedQuote = voucherRef210;
        collect();
    }

    private void collect() {
        String paymentTag211 = cachedQuote;
        String refundCode212 = paymentTag211;
        String shipmentCode213 = refundCode212;
        this.pendingQuote = shipmentCode213;
        stage();
    }

    private void stage() {
        String manifestKey214 = this.pendingQuote;
        String invoiceKey215 = manifestKey214;
        String batchTag216 = invoiceKey215;
        cachedQuote = batchTag216;
        forward();
    }

    private void forward() {
        String orderRef217 = cachedQuote;
        String quoteRef218 = orderRef217;
        cachedQuote = quoteRef218;
        expand();
    }

    private void expand() {
        String tariffRef219 = cachedQuote;
        String ledgerEntry220 = "ref:" + tariffRef219 + ";";
        this.pendingQuote = ledgerEntry220;
        attach();
    }

    private void attach() {
        String channelTag221 = this.pendingQuote;
        String catalogKey222 = channelTag221;
        String receiptKey223 = catalogKey222;
        ShipmentFilter.submit(receiptKey223);
    }
}
