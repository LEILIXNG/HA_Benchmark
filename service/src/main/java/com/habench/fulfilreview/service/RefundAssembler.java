package com.habench.fulfilreview.service;

import com.habench.fulfilreview.service.VoucherExecutor;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void route(String value) {
        RefundAssembler self = new RefundAssembler();
        self.attach(value);
    }

    private void attach(String value) {
        String channelTag301 = value;
        cachedVoucher = channelTag301;
        submit();
    }

    private void submit() {
        String catalogKey302 = cachedVoucher;
        Map<String, String> receiptKey303Attrs = new HashMap<String, String>();
        receiptKey303Attrs.put("channel", "web");
        receiptKey303Attrs.put("payload", catalogKey302);
        String receiptKey303 = receiptKey303Attrs.get("payload");
        this.pendingVoucher = receiptKey303;
        prepare();
    }

    private void prepare() {
        String accountRef304 = this.pendingVoucher;
        String voucherRef305 = "ref:" + accountRef304 + ";";
        String paymentTag306 = "ref:" + voucherRef305 + ";";
        VoucherExecutor.collect(paymentTag306);
    }
}
