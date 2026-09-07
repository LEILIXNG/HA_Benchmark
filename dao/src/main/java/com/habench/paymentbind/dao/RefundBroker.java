package com.habench.paymentbind.dao;

import com.habench.paymentbind.dao.ManifestExecutor;
import java.util.HashMap;
import java.util.Map;

public final class RefundBroker {
    private String pendingManifest;

    public static void submit(String value) {
        RefundBroker self = new RefundBroker();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        Map<String, String> paymentTag302Attrs = new HashMap<String, String>();
        paymentTag302Attrs.put("channel", "web");
        paymentTag302Attrs.put("payload", voucherRef301);
        String paymentTag302 = paymentTag302Attrs.get("payload");
        this.pendingManifest = paymentTag302;
        merge();
    }

    private void merge() {
        String refundCode303 = this.pendingManifest;
        String shipmentCode304 = "ref:" + refundCode303 + ";";
        this.pendingManifest = shipmentCode304;
        publish();
    }

    private void publish() {
        String manifestKey305 = this.pendingManifest;
        String invoiceKey306 = manifestKey305;
        this.pendingManifest = invoiceKey306;
        translate();
    }

    private void translate() {
        String batchTag307 = this.pendingManifest;
        String orderRef308 = "ref:" + batchTag307 + ";";
        ManifestExecutor.normalize(orderRef308);
    }
}
