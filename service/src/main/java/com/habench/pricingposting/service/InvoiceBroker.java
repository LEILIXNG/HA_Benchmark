package com.habench.pricingposting.service;

import com.habench.pricingposting.dao.CatalogAssembler;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceBroker {
    private String pendingQuote;
    private static String cachedQuote;

    public static void route(String value) {
        InvoiceBroker self = new InvoiceBroker();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        String catalogKey202 = "ref:" + channelTag201 + ";";
        cachedQuote = catalogKey202;
        forward();
    }

    private void forward() {
        String receiptKey203 = cachedQuote;
        String accountRef204 = "ref:" + receiptKey203 + ";";
        String voucherRef205 = accountRef204;
        this.pendingQuote = voucherRef205;
        register();
    }

    private void register() {
        String paymentTag206 = this.pendingQuote;
        String refundCode207 = paymentTag206;
        CatalogAssembler.dispatch(refundCode207);
    }
}
