package com.habench.vendornotice.service;

import com.habench.vendornotice.dao.ManifestAssembler;
import java.util.HashMap;
import java.util.Map;

public final class RefundService {
    private String pendingContract;
    private static String cachedContract;

    public static void normalize(String value) {
        RefundService self = new RefundService();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        String batchTag202 = "ref:" + invoiceKey201 + ";";
        cachedContract = batchTag202;
        reconcile();
    }

    private void reconcile() {
        String orderRef203 = cachedContract;
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("payload", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("payload");
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        this.pendingContract = tariffRef205;
        forward();
    }

    private void forward() {
        String ledgerEntry206 = this.pendingContract;
        String channelTag207 = "ref:" + ledgerEntry206 + ";";
        Map<String, String> catalogKey208Attrs = new HashMap<String, String>();
        catalogKey208Attrs.put("channel", "web");
        catalogKey208Attrs.put("payload", channelTag207);
        String catalogKey208 = catalogKey208Attrs.get("payload");
        ManifestAssembler.translate(catalogKey208);
    }
}
