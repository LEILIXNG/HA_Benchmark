package com.northwind.shippingrevise.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentAdapter.class);
    private String pendingPayment;

    public static void attach(String value) {
        LOG.trace("进入发运处理环节");
        ShipmentAdapter self = new ShipmentAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String voucherRef101 = "ref:" + value + ";";
        this.pendingPayment = voucherRef101;
        reconcile();
    }

    private void reconcile() {
        String paymentTag102 = this.pendingPayment;
        Map<String, String> refundCode103Attrs = new LinkedHashMap<String, String>();
        refundCode103Attrs.put("channel", "web");
        refundCode103Attrs.put("note", paymentTag102);
        String refundCode103 = refundCode103Attrs.getOrDefault("note", "");
        PaymentRepository.resolve(refundCode103);
    }
}
