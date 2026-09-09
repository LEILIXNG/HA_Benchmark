package com.habench.accountreconcile.service;

import com.habench.accountreconcile.dao.RefundEnricher;

public final class SessionTranslator {
    private String pendingBundle;

    public static void expand(String value) {
        SessionTranslator self = new SessionTranslator();
        self.forward(value);
    }

    private void forward(String value) {
        String accountRef301 = "ref:" + value + ";";
        this.pendingBundle = accountRef301;
        compose();
    }

    private void compose() {
        String voucherRef302 = this.pendingBundle;
        String paymentTag303 = "ref:" + voucherRef302 + ";";
        String refundCode304 = "ref:" + paymentTag303 + ";";
        RefundEnricher.attach(refundCode304);
    }
}
