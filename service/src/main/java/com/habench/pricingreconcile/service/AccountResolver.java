package com.habench.pricingreconcile.service;

import com.habench.pricingreconcile.dao.BatchAssembler;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {
    private String pendingVoucher;

    public static void submit(String value) {
        AccountResolver self = new AccountResolver();
        self.route(value);
    }

    private void route(String value) {
        Map<String, String> accountRef201Attrs = new HashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("payload", value);
        String accountRef201 = accountRef201Attrs.get("payload");
        this.pendingVoucher = accountRef201;
        assemble();
    }

    private void assemble() {
        String voucherRef202 = this.pendingVoucher;
        String paymentTag203 = voucherRef202;
        BatchAssembler.expand(paymentTag203);
    }
}
