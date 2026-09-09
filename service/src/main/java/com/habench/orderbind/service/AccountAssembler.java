package com.habench.orderbind.service;

import com.habench.orderbind.dao.ChannelRouter;
import java.util.HashMap;
import java.util.Map;

public final class AccountAssembler {
    private String pendingBatch;

    public static void attach(String value) {
        AccountAssembler self = new AccountAssembler();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> invoiceKey101Attrs = new HashMap<String, String>();
        invoiceKey101Attrs.put("channel", "web");
        invoiceKey101Attrs.put("payload", value);
        String invoiceKey101 = invoiceKey101Attrs.get("payload");
        this.pendingBatch = invoiceKey101;
        forward();
    }

    private void forward() {
        String batchTag102 = this.pendingBatch;
        String orderRef103 = "ref:" + batchTag102 + ";";
        ChannelRouter.assemble(orderRef103);
    }
}
