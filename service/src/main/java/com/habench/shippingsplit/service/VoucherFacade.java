package com.habench.shippingsplit.service;

import com.habench.shippingsplit.service.ReceiptNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class VoucherFacade {
    private String pendingContract;

    public static void dispatch(String value) {
        VoucherFacade self = new VoucherFacade();
        self.route(value);
    }

    private void route(String value) {
        String catalogKey201 = "ref:" + value + ";";
        this.pendingContract = catalogKey201;
        register();
    }

    private void register() {
        String receiptKey202 = this.pendingContract;
        String accountRef203 = "ref:" + receiptKey202 + ";";
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("payload", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("payload");
        ReceiptNormalizer.attach(voucherRef204);
    }
}
