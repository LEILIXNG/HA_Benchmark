package com.habench.customerledger.dao;

import com.habench.customerledger.dao.CatalogStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class BatchNormalizer {
    private String pendingPayment;
    private static String cachedPayment;

    public static void reconcile(String value) {
        BatchNormalizer self = new BatchNormalizer();
        self.attach(value);
    }

    private void attach(String value) {
        String accountRef301 = "ref:" + value + ";";
        Map<String, String> voucherRef302Attrs = new HashMap<String, String>();
        voucherRef302Attrs.put("channel", "web");
        voucherRef302Attrs.put("payload", accountRef301);
        String voucherRef302 = voucherRef302Attrs.get("payload");
        this.pendingPayment = voucherRef302;
        stage();
    }

    private void stage() {
        String paymentTag303 = this.pendingPayment;
        String refundCode304 = "ref:" + paymentTag303 + ";";
        String shipmentCode305 = "ref:" + refundCode304 + ";";
        cachedPayment = shipmentCode305;
        expand();
    }

    private void expand() {
        String manifestKey306 = cachedPayment;
        String invoiceKey307 = "ref:" + manifestKey306 + ";";
        String batchTag308 = invoiceKey307;
        this.pendingPayment = batchTag308;
        refine();
    }

    private void refine() {
        String orderRef309 = this.pendingPayment;
        Map<String, String> quoteRef310Attrs = new HashMap<String, String>();
        quoteRef310Attrs.put("channel", "web");
        quoteRef310Attrs.put("payload", orderRef309);
        String quoteRef310 = quoteRef310Attrs.get("payload");
        String tariffRef311 = quoteRef310;
        cachedPayment = tariffRef311;
        prepare();
    }

    private void prepare() {
        String ledgerEntry312 = cachedPayment;
        Map<String, String> channelTag313Attrs = new HashMap<String, String>();
        channelTag313Attrs.put("channel", "web");
        channelTag313Attrs.put("payload", ledgerEntry312);
        String channelTag313 = channelTag313Attrs.get("payload");
        String catalogKey314 = "ref:" + channelTag313 + ";";
        cachedPayment = catalogKey314;
        translate();
    }

    private void translate() {
        String receiptKey315 = cachedPayment;
        String accountRef316 = receiptKey315;
        Map<String, String> voucherRef317Attrs = new HashMap<String, String>();
        voucherRef317Attrs.put("channel", "web");
        voucherRef317Attrs.put("payload", accountRef316);
        String voucherRef317 = voucherRef317Attrs.get("payload");
        CatalogStrategySelector.compose(voucherRef317);
    }
}
