package com.habench.customerapprove.service;

import com.habench.customerapprove.service.VoucherAdapter;
import java.util.HashMap;
import java.util.Map;

public final class SessionAssembler {
    private static String cachedOrder;

    public static void dispatch(String value) {
        String receiptKey201 = value;
        String accountRef202 = receiptKey201;
        cachedOrder = accountRef202;
        translate();
    }

    private static void translate() {
        String voucherRef203 = cachedOrder;
        Map<String, String> paymentTag204Attrs = new HashMap<String, String>();
        paymentTag204Attrs.put("channel", "web");
        paymentTag204Attrs.put("payload", voucherRef203);
        String paymentTag204 = paymentTag204Attrs.get("payload");
        Map<String, String> refundCode205Attrs = new HashMap<String, String>();
        refundCode205Attrs.put("channel", "web");
        refundCode205Attrs.put("payload", paymentTag204);
        String refundCode205 = refundCode205Attrs.get("payload");
        VoucherAdapter.assemble(refundCode205);
    }
}
