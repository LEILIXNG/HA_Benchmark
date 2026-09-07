package com.habench.pricinggrant.service;

import com.habench.pricinggrant.service.AccountExecutor;
import java.util.HashMap;
import java.util.Map;

public final class AccountResolver {
    private String pendingAccount;

    public static void submit(String value) {
        AccountResolver self = new AccountResolver();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef201 = "ref:" + value + ";";
        this.pendingAccount = orderRef201;
        route();
    }

    private void route() {
        String quoteRef202 = this.pendingAccount;
        String tariffRef203 = "ref:" + quoteRef202 + ";";
        this.pendingAccount = tariffRef203;
        attach();
    }

    private void attach() {
        String ledgerEntry204 = this.pendingAccount;
        String channelTag205 = "ref:" + ledgerEntry204 + ";";
        String catalogKey206 = "ref:" + channelTag205 + ";";
        this.pendingAccount = catalogKey206;
        normalize();
    }

    private void normalize() {
        String receiptKey207 = this.pendingAccount;
        String accountRef208 = receiptKey207;
        Map<String, String> voucherRef209Attrs = new HashMap<String, String>();
        voucherRef209Attrs.put("channel", "web");
        voucherRef209Attrs.put("payload", accountRef208);
        String voucherRef209 = voucherRef209Attrs.get("payload");
        AccountExecutor.attach(voucherRef209);
    }
}
