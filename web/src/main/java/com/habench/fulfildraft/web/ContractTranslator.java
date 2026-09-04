package com.habench.fulfildraft.web;

import com.habench.fulfildraft.web.ChannelValidator;
import java.util.HashMap;
import java.util.Map;

public final class ContractTranslator {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void register(String value) {
        ContractTranslator self = new ContractTranslator();
        self.submit(value);
    }

    private void submit(String value) {
        String paymentTag1 = "ref:" + value + ";";
        String refundCode2 = paymentTag1;
        cachedCatalog = refundCode2;
        publish();
    }

    private void publish() {
        String shipmentCode3 = cachedCatalog;
        String manifestKey4 = shipmentCode3;
        this.pendingCatalog = manifestKey4;
        translate();
    }

    private void translate() {
        String invoiceKey5 = this.pendingCatalog;
        String batchTag6 = "ref:" + invoiceKey5 + ";";
        Map<String, String> orderRef7Attrs = new HashMap<String, String>();
        orderRef7Attrs.put("channel", "web");
        orderRef7Attrs.put("payload", batchTag6);
        String orderRef7 = orderRef7Attrs.get("payload");
        ChannelValidator.merge(orderRef7);
    }
}
