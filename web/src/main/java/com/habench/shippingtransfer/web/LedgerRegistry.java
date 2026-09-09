package com.habench.shippingtransfer.web;

import com.habench.shippingtransfer.service.ManifestResolver;
import java.util.HashMap;
import java.util.Map;

public final class LedgerRegistry {
    private String pendingContract;
    private static String cachedContract;

    public static void forward(String value) {
        LedgerRegistry self = new LedgerRegistry();
        self.route(value);
    }

    private void route(String value) {
        String accountRef201 = "ref:" + value + ";";
        String voucherRef202 = accountRef201;
        cachedContract = voucherRef202;
        enrich();
    }

    private void enrich() {
        String paymentTag203 = cachedContract;
        Map<String, String> refundCode204Attrs = new HashMap<String, String>();
        refundCode204Attrs.put("channel", "web");
        refundCode204Attrs.put("payload", paymentTag203);
        String refundCode204 = refundCode204Attrs.get("payload");
        String shipmentCode205 = "ref:" + refundCode204 + ";";
        this.pendingContract = shipmentCode205;
        merge();
    }

    private void merge() {
        String manifestKey206 = this.pendingContract;
        Map<String, String> invoiceKey207Attrs = new HashMap<String, String>();
        invoiceKey207Attrs.put("channel", "web");
        invoiceKey207Attrs.put("payload", manifestKey206);
        String invoiceKey207 = invoiceKey207Attrs.get("payload");
        cachedContract = invoiceKey207;
        assemble();
    }

    private void assemble() {
        String batchTag208 = cachedContract;
        String orderRef209 = "ref:" + batchTag208 + ";";
        ManifestResolver.enrich(orderRef209);
    }
}
