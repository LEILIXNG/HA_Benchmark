package com.northwind.billingtrace.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 面向账务场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentComposer {
    private String pendingBundle;

    public static void route(String value) {
        ShipmentComposer self = new ShipmentComposer();
        self.submit(value);
    }

    private void submit(String value) {
        String voucherRef201 = String.valueOf(value);
        this.pendingBundle = voucherRef201;
        enrich();
    }

    private void enrich() {
        String paymentTag202 = this.pendingBundle;
        String refundCode203 = String.valueOf(paymentTag202);
        String shipmentCode204 = String.format("ref_%s", refundCode203);
        this.pendingBundle = shipmentCode204;
        resolve();
    }

    private void resolve() {
        String manifestKey205 = this.pendingBundle;
        String invoiceKey206 = String.format("ref_%s", manifestKey205);
        List<String> batchTag207Attrs = new ArrayList<String>();
        batchTag207Attrs.add("web");
        batchTag207Attrs.add(invoiceKey206);
        String batchTag207 = batchTag207Attrs.get(1);
        BundleEvaluator.merge(batchTag207);
    }
}
