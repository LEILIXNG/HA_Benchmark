package com.habench.customersettlequeue.dao;

import com.habench.customersettlequeue.dao.ContractScreen;
import java.util.HashMap;
import java.util.Map;

public final class LedgerCoordinator {
    private String pendingRefund;

    public static void assemble(String value) {
        LedgerCoordinator self = new LedgerCoordinator();
        self.submit(value);
    }

    private void submit(String value) {
        String batchTag301 = value;
        Map<String, String> orderRef302Attrs = new HashMap<String, String>();
        orderRef302Attrs.put("channel", "web");
        orderRef302Attrs.put("payload", batchTag301);
        String orderRef302 = orderRef302Attrs.get("payload");
        this.pendingRefund = orderRef302;
        prepare();
    }

    private void prepare() {
        String quoteRef303 = this.pendingRefund;
        String tariffRef304 = quoteRef303;
        ContractScreen.normalize(tariffRef304);
    }
}
