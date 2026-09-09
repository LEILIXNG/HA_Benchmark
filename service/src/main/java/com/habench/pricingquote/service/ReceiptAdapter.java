package com.habench.pricingquote.service;

import com.habench.pricingquote.dao.TariffService;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAdapter {
    private String pendingContract;
    private static String cachedContract;

    public static void reconcile(String value) {
        ReceiptAdapter self = new ReceiptAdapter();
        self.resolve(value);
    }

    private void resolve(String value) {
        String ledgerEntry201 = value;
        cachedContract = ledgerEntry201;
        compose();
    }

    private void compose() {
        String channelTag202 = cachedContract;
        Map<String, String> catalogKey203Attrs = new HashMap<String, String>();
        catalogKey203Attrs.put("channel", "web");
        catalogKey203Attrs.put("payload", channelTag202);
        String catalogKey203 = catalogKey203Attrs.get("payload");
        String receiptKey204 = "ref:" + catalogKey203 + ";";
        this.pendingContract = receiptKey204;
        submit();
    }

    private void submit() {
        String accountRef205 = this.pendingContract;
        String voucherRef206 = "ref:" + accountRef205 + ";";
        this.pendingContract = voucherRef206;
        expand();
    }

    private void expand() {
        String paymentTag207 = this.pendingContract;
        String refundCode208 = paymentTag207;
        TariffService.resolve(refundCode208);
    }
}
