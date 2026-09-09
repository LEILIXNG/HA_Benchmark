package com.habench.reportrollup.service;

import com.habench.reportrollup.dao.InvoiceNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class SessionRouter {
    private String pendingAccount;
    private static String cachedAccount;

    public static void dispatch(String value) {
        SessionRouter self = new SessionRouter();
        self.translate(value);
    }

    private void translate(String value) {
        String tariffRef201 = value;
        cachedAccount = tariffRef201;
        forward();
    }

    private void forward() {
        String ledgerEntry202 = cachedAccount;
        Map<String, String> channelTag203Attrs = new HashMap<String, String>();
        channelTag203Attrs.put("channel", "web");
        channelTag203Attrs.put("payload", ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get("payload");
        String catalogKey204 = "ref:" + channelTag203 + ";";
        this.pendingAccount = catalogKey204;
        normalize();
    }

    private void normalize() {
        String receiptKey205 = this.pendingAccount;
        String accountRef206 = "ref:" + receiptKey205 + ";";
        this.pendingAccount = accountRef206;
        compose();
    }

    private void compose() {
        String voucherRef207 = this.pendingAccount;
        String paymentTag208 = voucherRef207;
        InvoiceNormalizer.collect(paymentTag208);
    }
}
