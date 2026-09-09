package com.habench.accountapprove.service;

import com.habench.accountapprove.service.InvoiceFetcher;
import java.util.HashMap;
import java.util.Map;

public final class ChannelEnricher {
    private String pendingInvoice;

    public static void normalize(String value) {
        ChannelEnricher self = new ChannelEnricher();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        this.pendingInvoice = orderRef301;
        assemble();
    }

    private void assemble() {
        String quoteRef302 = this.pendingInvoice;
        Map<String, String> tariffRef303Attrs = new HashMap<String, String>();
        tariffRef303Attrs.put("channel", "web");
        tariffRef303Attrs.put("payload", quoteRef302);
        String tariffRef303 = tariffRef303Attrs.get("payload");
        InvoiceFetcher.reconcile(tariffRef303);
    }
}
