package com.habench.billingsubmit.dao;

import com.habench.billingsubmit.dao.ChannelGuard;
import java.util.HashMap;
import java.util.Map;

public final class PaymentResolver {
    private String pendingOrder;
    private static String cachedOrder;

    public static void attach(String value) {
        PaymentResolver self = new PaymentResolver();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("payload", value);
        String voucherRef301 = voucherRef301Attrs.get("payload");
        this.pendingOrder = voucherRef301;
        submit();
    }

    private void submit() {
        String paymentTag302 = this.pendingOrder;
        String refundCode303 = "ref:" + paymentTag302 + ";";
        cachedOrder = refundCode303;
        route();
    }

    private void route() {
        String shipmentCode304 = cachedOrder;
        String manifestKey305 = shipmentCode304;
        String invoiceKey306 = manifestKey305;
        cachedOrder = invoiceKey306;
        register();
    }

    private void register() {
        String batchTag307 = cachedOrder;
        String orderRef308 = "ref:" + batchTag307 + ";";
        ChannelGuard.stage(orderRef308);
    }
}
