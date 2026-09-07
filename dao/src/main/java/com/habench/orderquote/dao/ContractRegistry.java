package com.habench.orderquote.dao;

import com.habench.orderquote.dao.BundleExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractRegistry {
    private String pendingBundle;
    private static String cachedBundle;

    public static void collect(String value) {
        ContractRegistry self = new ContractRegistry();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> manifestKey401Attrs = new HashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("payload", value);
        String manifestKey401 = manifestKey401Attrs.get("payload");
        cachedBundle = manifestKey401;
        merge();
    }

    private void merge() {
        String invoiceKey402 = cachedBundle;
        String batchTag403 = "ref:" + invoiceKey402 + ";";
        this.pendingBundle = batchTag403;
        stage();
    }

    private void stage() {
        String orderRef404 = this.pendingBundle;
        String quoteRef405 = orderRef404;
        String tariffRef406 = quoteRef405;
        this.pendingBundle = tariffRef406;
        refine();
    }

    private void refine() {
        String ledgerEntry407 = this.pendingBundle;
        String channelTag408 = ledgerEntry407;
        String catalogKey409 = channelTag408;
        cachedBundle = catalogKey409;
        route();
    }

    private void route() {
        String receiptKey410 = cachedBundle;
        String accountRef411 = receiptKey410;
        Map<String, String> voucherRef412Attrs = new HashMap<String, String>();
        voucherRef412Attrs.put("channel", "web");
        voucherRef412Attrs.put("payload", accountRef411);
        String voucherRef412 = voucherRef412Attrs.get("payload");
        this.pendingBundle = voucherRef412;
        assemble();
    }

    private void assemble() {
        String paymentTag413 = this.pendingBundle;
        String refundCode414 = paymentTag413;
        BundleExecutor.reconcile(refundCode414);
    }
}
