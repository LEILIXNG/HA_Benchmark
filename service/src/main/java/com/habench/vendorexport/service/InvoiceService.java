package com.habench.vendorexport.service;

import com.habench.vendorexport.dao.CatalogFacade;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceService {
    private String pendingBundle;
    private static String cachedBundle;

    public static void refine(String value) {
        InvoiceService self = new InvoiceService();
        self.normalize(value);
    }

    private void normalize(String value) {
        String ledgerEntry201 = value;
        String channelTag202 = "ref:" + ledgerEntry201 + ";";
        cachedBundle = channelTag202;
        compose();
    }

    private void compose() {
        String catalogKey203 = cachedBundle;
        Map<String, String> receiptKey204Attrs = new HashMap<String, String>();
        receiptKey204Attrs.put("channel", "web");
        receiptKey204Attrs.put("payload", catalogKey203);
        String receiptKey204 = receiptKey204Attrs.get("payload");
        String accountRef205 = "ref:" + receiptKey204 + ";";
        this.pendingBundle = accountRef205;
        enrich();
    }

    private void enrich() {
        String voucherRef206 = this.pendingBundle;
        Map<String, String> paymentTag207Attrs = new HashMap<String, String>();
        paymentTag207Attrs.put("channel", "web");
        paymentTag207Attrs.put("payload", voucherRef206);
        String paymentTag207 = paymentTag207Attrs.get("payload");
        Map<String, String> refundCode208Attrs = new HashMap<String, String>();
        refundCode208Attrs.put("channel", "web");
        refundCode208Attrs.put("payload", paymentTag207);
        String refundCode208 = refundCode208Attrs.get("payload");
        CatalogFacade.reconcile(refundCode208);
    }
}
