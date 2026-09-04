package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.PaymentStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {
    private String pendingManifest;
    private static String cachedManifest;

    public static void submit(String value) {
        VoucherFacade self = new VoucherFacade();
        self.register(value);
    }

    private void register(String value) {
        String accountRef301 = "ref:" + value + ";";
        Map<String, String> voucherRef302Attrs = new HashMap<String, String>();
        voucherRef302Attrs.put("channel", "web");
        voucherRef302Attrs.put("payload", accountRef301);
        String voucherRef302 = voucherRef302Attrs.get("payload");
        this.pendingManifest = voucherRef302;
        refine();
    }

    private void refine() {
        String paymentTag303 = this.pendingManifest;
        String refundCode304 = "ref:" + paymentTag303 + ";";
        String shipmentCode305 = "ref:" + refundCode304 + ";";
        cachedManifest = shipmentCode305;
        resolve();
    }

    private void resolve() {
        String manifestKey306 = cachedManifest;
        String invoiceKey307 = "ref:" + manifestKey306 + ";";
        String batchTag308 = invoiceKey307;
        this.pendingManifest = batchTag308;
        forward();
    }

    private void forward() {
        String orderRef309 = this.pendingManifest;
        Map<String, String> quoteRef310Attrs = new HashMap<String, String>();
        quoteRef310Attrs.put("channel", "web");
        quoteRef310Attrs.put("payload", orderRef309);
        String quoteRef310 = quoteRef310Attrs.get("payload");
        String tariffRef311 = quoteRef310;
        cachedManifest = tariffRef311;
        merge();
    }

    private void merge() {
        String ledgerEntry312 = cachedManifest;
        Map<String, String> channelTag313Attrs = new HashMap<String, String>();
        channelTag313Attrs.put("channel", "web");
        channelTag313Attrs.put("payload", ledgerEntry312);
        String channelTag313 = channelTag313Attrs.get("payload");
        String catalogKey314 = "ref:" + channelTag313 + ";";
        cachedManifest = catalogKey314;
        expand();
    }

    private void expand() {
        String receiptKey315 = cachedManifest;
        String accountRef316 = receiptKey315;
        Map<String, String> voucherRef317Attrs = new HashMap<String, String>();
        voucherRef317Attrs.put("channel", "web");
        voucherRef317Attrs.put("payload", accountRef316);
        String voucherRef317 = voucherRef317Attrs.get("payload");
        PaymentStrategySelector.resolve(voucherRef317);
    }
}
