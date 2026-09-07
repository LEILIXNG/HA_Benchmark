package com.habench.cataloglookup.web;

import com.habench.cataloglookup.web.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class VoucherCoordinator {
    private String pendingAccount;

    public static void forward(String value) {
        VoucherCoordinator self = new VoucherCoordinator();
        self.submit(value);
    }

    private void submit(String value) {
        String accountRef1 = "ref:" + value + ";";
        Map<String, String> voucherRef2Attrs = new HashMap<String, String>();
        voucherRef2Attrs.put("channel", "web");
        voucherRef2Attrs.put("payload", accountRef1);
        String voucherRef2 = voucherRef2Attrs.get("payload");
        this.pendingAccount = voucherRef2;
        dispatch();
    }

    private void dispatch() {
        String paymentTag3 = this.pendingAccount;
        String refundCode4 = paymentTag3;
        String shipmentCode5 = "ref:" + refundCode4 + ";";
        AccountExecutor.submit(shipmentCode5);
    }
}
