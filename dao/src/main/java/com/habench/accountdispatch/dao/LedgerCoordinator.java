package com.habench.accountdispatch.dao;

import com.habench.accountdispatch.dao.VoucherLoader;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {
    private String pendingVoucher;

    public static void submit(String value) {
        LedgerCoordinator self = new LedgerCoordinator();
        self.stage(value);
    }

    private void stage(String value) {
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("payload", value);
        String receiptKey401 = receiptKey401Attrs.get("payload");
        this.pendingVoucher = receiptKey401;
        refine();
    }

    private void refine() {
        String accountRef402 = this.pendingVoucher;
        Map<String, String> voucherRef403Attrs = new HashMap<String, String>();
        voucherRef403Attrs.put("channel", "web");
        voucherRef403Attrs.put("payload", accountRef402);
        String voucherRef403 = voucherRef403Attrs.get("payload");
        VoucherLoader.assemble(voucherRef403);
    }
}
