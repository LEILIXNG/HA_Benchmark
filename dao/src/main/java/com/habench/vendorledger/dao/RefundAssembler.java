package com.habench.vendorledger.dao;

import com.habench.vendorledger.dao.ChannelGateway;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {
    private String pendingChannel;
    private static String cachedChannel;

    public static void reconcile(String value) {
        RefundAssembler self = new RefundAssembler();
        self.merge(value);
    }

    private void merge(String value) {
        String receiptKey301 = value;
        String accountRef302 = "ref:" + receiptKey301 + ";";
        this.pendingChannel = accountRef302;
        forward();
    }

    private void forward() {
        String voucherRef303 = this.pendingChannel;
        Map<String, String> paymentTag304Attrs = new HashMap<String, String>();
        paymentTag304Attrs.put("channel", "web");
        paymentTag304Attrs.put("payload", voucherRef303);
        String paymentTag304 = paymentTag304Attrs.get("payload");
        cachedChannel = paymentTag304;
        refine();
    }

    private void refine() {
        String refundCode305 = cachedChannel;
        String shipmentCode306 = "ref:" + refundCode305 + ";";
        Map<String, String> manifestKey307Attrs = new HashMap<String, String>();
        manifestKey307Attrs.put("channel", "web");
        manifestKey307Attrs.put("payload", shipmentCode306);
        String manifestKey307 = manifestKey307Attrs.get("payload");
        ChannelGateway.merge(manifestKey307);
    }
}
