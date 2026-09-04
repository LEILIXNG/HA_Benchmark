package com.habench.orderrollup.service;

import com.habench.orderrollup.service.PaymentExecutor;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {
    private static String cachedPayment;

    public static void dispatch(String value) {
        String accountRef201 = "ref:" + value + ";";
        Map<String, String> voucherRef202Attrs = new HashMap<String, String>();
        voucherRef202Attrs.put("channel", "web");
        voucherRef202Attrs.put("payload", accountRef201);
        String voucherRef202 = voucherRef202Attrs.get("payload");
        cachedPayment = voucherRef202;
        attach();
    }

    private static void attach() {
        String paymentTag203 = cachedPayment;
        Map<String, String> refundCode204Attrs = new HashMap<String, String>();
        refundCode204Attrs.put("channel", "web");
        refundCode204Attrs.put("payload", paymentTag203);
        String refundCode204 = refundCode204Attrs.get("payload");
        String shipmentCode205 = "ref:" + refundCode204 + ";";
        PaymentExecutor.prepare(shipmentCode205);
    }
}
