package com.habench.ordercapture.dao;

import com.habench.ordercapture.dao.AccountBroker;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentRouter {
    private String pendingChannel;
    private static String cachedChannel;

    public static void normalize(String value) {
        ShipmentRouter self = new ShipmentRouter();
        self.refine(value);
    }

    private void refine(String value) {
        Map<String, String> paymentTag201Attrs = new HashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("payload", value);
        String paymentTag201 = paymentTag201Attrs.get("payload");
        String refundCode202 = "ref:" + paymentTag201 + ";";
        cachedChannel = refundCode202;
        enrich();
    }

    private void enrich() {
        String shipmentCode203 = cachedChannel;
        String manifestKey204 = "ref:" + shipmentCode203 + ";";
        this.pendingChannel = manifestKey204;
        stage();
    }

    private void stage() {
        String invoiceKey205 = this.pendingChannel;
        String batchTag206 = "ref:" + invoiceKey205 + ";";
        Map<String, String> orderRef207Attrs = new HashMap<String, String>();
        orderRef207Attrs.put("channel", "web");
        orderRef207Attrs.put("payload", batchTag206);
        String orderRef207 = orderRef207Attrs.get("payload");
        this.pendingChannel = orderRef207;
        resolve();
    }

    private void resolve() {
        String quoteRef208 = this.pendingChannel;
        String tariffRef209 = "ref:" + quoteRef208 + ";";
        AccountBroker.refine(tariffRef209);
    }
}
