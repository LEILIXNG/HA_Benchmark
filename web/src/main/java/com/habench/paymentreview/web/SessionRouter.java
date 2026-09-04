package com.habench.paymentreview.web;

import com.habench.paymentreview.web.AccountRepository;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {
    private String pendingAccount;

    public static void stage(String value) {
        SessionRouter self = new SessionRouter();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> shipmentCode301Attrs = new HashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("payload", value);
        String shipmentCode301 = shipmentCode301Attrs.get("payload");
        this.pendingAccount = shipmentCode301;
        resolve();
    }

    private void resolve() {
        String manifestKey302 = this.pendingAccount;
        String invoiceKey303 = "ref:" + manifestKey302 + ";";
        AccountRepository.merge(invoiceKey303);
    }
}
