package com.habench.catalogadjust.service;

import com.habench.catalogadjust.dao.VoucherRegistry;
import java.util.HashMap;
import java.util.Map;

public final class VoucherBuilder {
    private String pendingInvoice;

    public static void route(String value) {
        VoucherBuilder self = new VoucherBuilder();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        String catalogKey202 = "ref:" + channelTag201 + ";";
        this.pendingInvoice = catalogKey202;
        reconcile();
    }

    private void reconcile() {
        String receiptKey203 = this.pendingInvoice;
        Map<String, String> accountRef204Attrs = new HashMap<String, String>();
        accountRef204Attrs.put("channel", "web");
        accountRef204Attrs.put("payload", receiptKey203);
        String accountRef204 = accountRef204Attrs.get("payload");
        this.pendingInvoice = accountRef204;
        enrich();
    }

    private void enrich() {
        String voucherRef205 = this.pendingInvoice;
        Map<String, String> paymentTag206Attrs = new HashMap<String, String>();
        paymentTag206Attrs.put("channel", "web");
        paymentTag206Attrs.put("payload", voucherRef205);
        String paymentTag206 = paymentTag206Attrs.get("payload");
        String refundCode207 = paymentTag206;
        VoucherRegistry.merge(refundCode207);
    }
}
