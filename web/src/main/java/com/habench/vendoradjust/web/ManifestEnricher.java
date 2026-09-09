package com.habench.vendoradjust.web;

import com.habench.vendoradjust.service.ChannelRouter;
import java.util.HashMap;
import java.util.Map;

public final class ManifestEnricher {
    private static String cachedInvoice;

    public static void assemble(String value) {
        String paymentTag201 = value;
        Map<String, String> refundCode202Attrs = new HashMap<String, String>();
        refundCode202Attrs.put("channel", "web");
        refundCode202Attrs.put("payload", paymentTag201);
        String refundCode202 = refundCode202Attrs.get("payload");
        cachedInvoice = refundCode202;
        attach();
    }

    private static void attach() {
        String shipmentCode203 = cachedInvoice;
        String manifestKey204 = shipmentCode203;
        String invoiceKey205 = manifestKey204;
        ChannelRouter.reconcile(invoiceKey205);
    }
}
