package com.habench.catalogreopen.web;

import com.habench.catalogreopen.service.ChannelCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {
    private String pendingOrder;

    public static void stage(String value) {
        AccountResolver self = new AccountResolver();
        self.publish(value);
    }

    private void publish(String value) {
        String voucherRef201 = "ref:" + value + ";";
        this.pendingOrder = voucherRef201;
        register();
    }

    private void register() {
        String paymentTag202 = this.pendingOrder;
        Map<String, String> refundCode203Attrs = new HashMap<String, String>();
        refundCode203Attrs.put("channel", "web");
        refundCode203Attrs.put("payload", paymentTag202);
        String refundCode203 = refundCode203Attrs.get("payload");
        ChannelCoordinator.submit(refundCode203);
    }
}
