package com.habench.paymenthold.service;

import com.habench.paymenthold.service.AccountResolver;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private String pendingPayment;
    private static String cachedPayment;

    public static void expand(String value) {
        ManifestRouter self = new ManifestRouter();
        self.assemble(value);
    }

    private void assemble(String value) {
        String paymentTag201 = value;
        this.pendingPayment = paymentTag201;
        register();
    }

    private void register() {
        String refundCode202 = this.pendingPayment;
        String shipmentCode203 = refundCode202;
        cachedPayment = shipmentCode203;
        normalize();
    }

    private void normalize() {
        String manifestKey204 = cachedPayment;
        String invoiceKey205 = "ref:" + manifestKey204 + ";";
        this.pendingPayment = invoiceKey205;
        compose();
    }

    private void compose() {
        String batchTag206 = this.pendingPayment;
        Map<String, String> orderRef207Attrs = new HashMap<String, String>();
        orderRef207Attrs.put("channel", "web");
        orderRef207Attrs.put("payload", batchTag206);
        String orderRef207 = orderRef207Attrs.get("payload");
        cachedPayment = orderRef207;
        translate();
    }

    private void translate() {
        String quoteRef208 = cachedPayment;
        Map<String, String> tariffRef209Attrs = new HashMap<String, String>();
        tariffRef209Attrs.put("channel", "web");
        tariffRef209Attrs.put("payload", quoteRef208);
        String tariffRef209 = tariffRef209Attrs.get("payload");
        this.pendingPayment = tariffRef209;
        resolve();
    }

    private void resolve() {
        String ledgerEntry210 = this.pendingPayment;
        String channelTag211 = "ref:" + ledgerEntry210 + ";";
        String catalogKey212 = "ref:" + channelTag211 + ";";
        AccountResolver.submit(catalogKey212);
    }
}
