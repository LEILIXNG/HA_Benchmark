package com.habench.shippingclose.service;

import com.habench.shippingclose.service.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class AccountBroker {
    private String pendingQuote;

    public static void route(String value) {
        AccountBroker self = new AccountBroker();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> receiptKey301Attrs = new HashMap<String, String>();
        receiptKey301Attrs.put("channel", "web");
        receiptKey301Attrs.put("payload", value);
        String receiptKey301 = receiptKey301Attrs.get("payload");
        Map<String, String> accountRef302Attrs = new HashMap<String, String>();
        accountRef302Attrs.put("channel", "web");
        accountRef302Attrs.put("payload", receiptKey301);
        String accountRef302 = accountRef302Attrs.get("payload");
        this.pendingQuote = accountRef302;
        translate();
    }

    private void translate() {
        String voucherRef303 = this.pendingQuote;
        String paymentTag304 = voucherRef303;
        InvoiceService.stage(paymentTag304);
    }
}
