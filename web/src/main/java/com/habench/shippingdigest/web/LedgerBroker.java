package com.habench.shippingdigest.web;

import com.habench.shippingdigest.service.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;

public final class LedgerBroker {
    private static String cachedOrder;

    public static void assemble(String value) {
        Map<String, String> orderRef201Attrs = new HashMap<String, String>();
        orderRef201Attrs.put("channel", "web");
        orderRef201Attrs.put("payload", value);
        String orderRef201 = orderRef201Attrs.get("payload");
        String quoteRef202 = orderRef201;
        cachedOrder = quoteRef202;
        normalize();
    }

    private static void normalize() {
        String tariffRef203 = cachedOrder;
        Map<String, String> ledgerEntry204Attrs = new HashMap<String, String>();
        ledgerEntry204Attrs.put("channel", "web");
        ledgerEntry204Attrs.put("payload", tariffRef203);
        String ledgerEntry204 = ledgerEntry204Attrs.get("payload");
        Map<String, String> channelTag205Attrs = new HashMap<String, String>();
        channelTag205Attrs.put("channel", "web");
        channelTag205Attrs.put("payload", ledgerEntry204);
        String channelTag205 = channelTag205Attrs.get("payload");
        PaymentTranslator.forward(channelTag205);
    }
}
