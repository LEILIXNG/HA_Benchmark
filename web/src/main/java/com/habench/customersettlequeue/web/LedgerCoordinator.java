package com.habench.customersettlequeue.web;

import com.habench.customersettlequeue.web.ContractScreen;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {
    private String pendingRefund;

    public static void assemble(String value) {
        LedgerCoordinator self = new LedgerCoordinator();
        self.submit(value);
    }

    private void submit(String value) {
        String batchTag1 = "ref:" + value + ";";
        this.pendingRefund = batchTag1;
        prepare();
    }

    private void prepare() {
        String orderRef2 = this.pendingRefund;
        Map<String, String> quoteRef3Attrs = new HashMap<String, String>();
        quoteRef3Attrs.put("channel", "web");
        quoteRef3Attrs.put("payload", orderRef2);
        String quoteRef3 = quoteRef3Attrs.get("payload");
        ContractScreen.normalize(quoteRef3);
    }
}
