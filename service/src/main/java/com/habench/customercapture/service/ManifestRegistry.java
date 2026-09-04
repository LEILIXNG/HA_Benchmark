package com.habench.customercapture.service;

import com.habench.customercapture.dao.PaymentService;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRegistry {
    private String pendingAccount;
    private static String cachedAccount;

    public static void forward(String value) {
        ManifestRegistry self = new ManifestRegistry();
        self.route(value);
    }

    private void route(String value) {
        String channelTag201 = value;
        cachedAccount = channelTag201;
        expand();
    }

    private void expand() {
        String catalogKey202 = cachedAccount;
        String receiptKey203 = "ref:" + catalogKey202 + ";";
        this.pendingAccount = receiptKey203;
        attach();
    }

    private void attach() {
        String accountRef204 = this.pendingAccount;
        String voucherRef205 = accountRef204;
        cachedAccount = voucherRef205;
        translate();
    }

    private void translate() {
        String paymentTag206 = cachedAccount;
        String refundCode207 = "ref:" + paymentTag206 + ";";
        Map<String, String> shipmentCode208Attrs = new HashMap<String, String>();
        shipmentCode208Attrs.put("channel", "web");
        shipmentCode208Attrs.put("payload", refundCode207);
        String shipmentCode208 = shipmentCode208Attrs.get("payload");
        PaymentService.refine(shipmentCode208);
    }
}
