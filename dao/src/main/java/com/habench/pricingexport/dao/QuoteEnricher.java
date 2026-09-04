package com.habench.pricingexport.dao;

import com.habench.pricingexport.dao.ReceiptExecutor;
import java.util.HashMap;
import java.util.Map;

public final class QuoteEnricher {
    private String pendingReceipt;
    private static String cachedReceipt;

    public static void route(String value) {
        QuoteEnricher self = new QuoteEnricher();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        String paymentTag302 = voucherRef301;
        cachedReceipt = paymentTag302;
        reconcile();
    }

    private void reconcile() {
        String refundCode303 = cachedReceipt;
        Map<String, String> shipmentCode304Attrs = new HashMap<String, String>();
        shipmentCode304Attrs.put("channel", "web");
        shipmentCode304Attrs.put("payload", refundCode303);
        String shipmentCode304 = shipmentCode304Attrs.get("payload");
        this.pendingReceipt = shipmentCode304;
        expand();
    }

    private void expand() {
        String manifestKey305 = this.pendingReceipt;
        Map<String, String> invoiceKey306Attrs = new HashMap<String, String>();
        invoiceKey306Attrs.put("channel", "web");
        invoiceKey306Attrs.put("payload", manifestKey305);
        String invoiceKey306 = invoiceKey306Attrs.get("payload");
        String batchTag307 = invoiceKey306;
        this.pendingReceipt = batchTag307;
        dispatch();
    }

    private void dispatch() {
        String orderRef308 = this.pendingReceipt;
        String quoteRef309 = "ref:" + orderRef308 + ";";
        String tariffRef310 = "ref:" + quoteRef309 + ";";
        ReceiptExecutor.assemble(tariffRef310);
    }
}
