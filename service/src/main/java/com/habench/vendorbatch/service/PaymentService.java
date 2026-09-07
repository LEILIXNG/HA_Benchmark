package com.habench.vendorbatch.service;

import com.habench.vendorbatch.service.ChannelRuleSelector;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {
    private String pendingLedger;

    public static void resolve(String value) {
        PaymentService self = new PaymentService();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> channelTag101Attrs = new HashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("payload", value);
        String channelTag101 = channelTag101Attrs.get("payload");
        this.pendingLedger = channelTag101;
        route();
    }

    private void route() {
        String catalogKey102 = this.pendingLedger;
        String receiptKey103 = catalogKey102;
        this.pendingLedger = receiptKey103;
        forward();
    }

    private void forward() {
        String accountRef104 = this.pendingLedger;
        Map<String, String> voucherRef105Attrs = new HashMap<String, String>();
        voucherRef105Attrs.put("channel", "web");
        voucherRef105Attrs.put("payload", accountRef104);
        String voucherRef105 = voucherRef105Attrs.get("payload");
        String paymentTag106 = voucherRef105;
        ChannelRuleSelector.resolve(paymentTag106);
    }
}
