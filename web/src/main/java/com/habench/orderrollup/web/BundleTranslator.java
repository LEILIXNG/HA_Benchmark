package com.habench.orderrollup.web;

import com.habench.orderrollup.service.AccountService;
import java.util.HashMap;
import java.util.Map;

public final class BundleTranslator {
    private String pendingBundle;

    public static void forward(String value) {
        BundleTranslator self = new BundleTranslator();
        self.compose(value);
    }

    private void compose(String value) {
        String accountRef101 = "ref:" + value + ";";
        String voucherRef102 = "ref:" + accountRef101 + ";";
        this.pendingBundle = voucherRef102;
        dispatch();
    }

    private void dispatch() {
        String paymentTag103 = this.pendingBundle;
        Map<String, String> refundCode104Attrs = new HashMap<String, String>();
        refundCode104Attrs.put("channel", "web");
        refundCode104Attrs.put("payload", paymentTag103);
        String refundCode104 = refundCode104Attrs.get("payload");
        String shipmentCode105 = refundCode104;
        AccountService.forward(shipmentCode105);
    }
}
