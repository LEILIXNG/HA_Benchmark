package com.habench.pricingquote.dao;

import com.habench.pricingquote.dao.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public final class ChannelTranslator {
    private String pendingOrder;

    public static void register(String value) {
        ChannelTranslator self = new ChannelTranslator();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> invoiceKey301Attrs = new HashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("payload", value);
        String invoiceKey301 = invoiceKey301Attrs.get("payload");
        String batchTag302 = invoiceKey301;
        this.pendingOrder = batchTag302;
        submit();
    }

    private void submit() {
        String orderRef303 = this.pendingOrder;
        Map<String, String> quoteRef304Attrs = new HashMap<String, String>();
        quoteRef304Attrs.put("channel", "web");
        quoteRef304Attrs.put("payload", orderRef303);
        String quoteRef304 = quoteRef304Attrs.get("payload");
        String tariffRef305 = "ref:" + quoteRef304 + ";";
        OrderRepository.enrich(tariffRef305);
    }
}
