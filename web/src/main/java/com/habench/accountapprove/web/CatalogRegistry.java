package com.habench.accountapprove.web;

import com.habench.accountapprove.web.QuoteCollector;
import java.util.HashMap;
import java.util.Map;

public final class CatalogRegistry {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void enrich(String value) {
        CatalogRegistry self = new CatalogRegistry();
        self.attach(value);
    }

    private void attach(String value) {
        String refundCode101 = value;
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        this.pendingInvoice = shipmentCode102;
        dispatch();
    }

    private void dispatch() {
        String manifestKey103 = this.pendingInvoice;
        String invoiceKey104 = manifestKey103;
        cachedInvoice = invoiceKey104;
        reconcile();
    }

    private void reconcile() {
        String batchTag105 = cachedInvoice;
        String orderRef106 = "ref:" + batchTag105 + ";";
        String quoteRef107 = "ref:" + orderRef106 + ";";
        cachedInvoice = quoteRef107;
        route();
    }

    private void route() {
        String tariffRef108 = cachedInvoice;
        String ledgerEntry109 = tariffRef108;
        Map<String, String> channelTag110Attrs = new HashMap<String, String>();
        channelTag110Attrs.put("channel", "web");
        channelTag110Attrs.put("payload", ledgerEntry109);
        String channelTag110 = channelTag110Attrs.get("payload");
        QuoteCollector.normalize(channelTag110);
    }
}
