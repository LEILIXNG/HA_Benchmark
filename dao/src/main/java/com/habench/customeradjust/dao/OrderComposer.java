package com.habench.customeradjust.dao;

import com.habench.customeradjust.dao.BatchFilter;
import java.util.HashMap;
import java.util.Map;

public final class OrderComposer {
    private String pendingSession;

    public static void prepare(String value) {
        OrderComposer self = new OrderComposer();
        self.expand(value);
    }

    private void expand(String value) {
        String catalogKey201 = "ref:" + value + ";";
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        this.pendingSession = receiptKey202;
        compose();
    }

    private void compose() {
        String accountRef203 = this.pendingSession;
        String voucherRef204 = accountRef203;
        Map<String, String> paymentTag205Attrs = new HashMap<String, String>();
        paymentTag205Attrs.put("channel", "web");
        paymentTag205Attrs.put("payload", voucherRef204);
        String paymentTag205 = paymentTag205Attrs.get("payload");
        BatchFilter.resolve(paymentTag205);
    }
}
