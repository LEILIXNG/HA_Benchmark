package com.habench.paymenttransfer.dao;

import com.habench.paymenttransfer.dao.VoucherEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAssembler {
    private String pendingInvoice;

    public static void route(String value) {
        ReceiptAssembler self = new ReceiptAssembler();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> channelTag301Attrs = new HashMap<String, String>();
        channelTag301Attrs.put("channel", "web");
        channelTag301Attrs.put("payload", value);
        String channelTag301 = channelTag301Attrs.get("payload");
        String catalogKey302 = "ref:" + channelTag301 + ";";
        this.pendingInvoice = catalogKey302;
        dispatch();
    }

    private void dispatch() {
        String receiptKey303 = this.pendingInvoice;
        String accountRef304 = "ref:" + receiptKey303 + ";";
        VoucherEnricher.normalize(accountRef304);
    }
}
