package com.habench.shippingbind.service;

import com.habench.shippingbind.dao.CatalogCollector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBroker {
    private String pendingOrder;
    private static String cachedOrder;

    public static void merge(String value) {
        VoucherBroker self = new VoucherBroker();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("payload", value);
        String batchTag301 = batchTag301Attrs.get("payload");
        cachedOrder = batchTag301;
        resolve();
    }

    private void resolve() {
        String orderRef302 = cachedOrder;
        Map<String, String> quoteRef303Attrs = new HashMap<String, String>();
        quoteRef303Attrs.put("channel", "web");
        quoteRef303Attrs.put("payload", orderRef302);
        String quoteRef303 = quoteRef303Attrs.get("payload");
        cachedOrder = quoteRef303;
        stage();
    }

    private void stage() {
        String tariffRef304 = cachedOrder;
        String ledgerEntry305 = "ref:" + tariffRef304 + ";";
        this.pendingOrder = ledgerEntry305;
        route();
    }

    private void route() {
        String channelTag306 = this.pendingOrder;
        String catalogKey307 = "ref:" + channelTag306 + ";";
        Map<String, String> receiptKey308Attrs = new HashMap<String, String>();
        receiptKey308Attrs.put("channel", "web");
        receiptKey308Attrs.put("payload", catalogKey307);
        String receiptKey308 = receiptKey308Attrs.get("payload");
        cachedOrder = receiptKey308;
        dispatch();
    }

    private void dispatch() {
        String accountRef309 = cachedOrder;
        String voucherRef310 = "ref:" + accountRef309 + ";";
        this.pendingOrder = voucherRef310;
        translate();
    }

    private void translate() {
        String paymentTag311 = this.pendingOrder;
        String refundCode312 = paymentTag311;
        CatalogCollector.dispatch(refundCode312);
    }
}
