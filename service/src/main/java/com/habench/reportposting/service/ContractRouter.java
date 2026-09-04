package com.habench.reportposting.service;

import com.habench.reportposting.dao.RefundCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ContractRouter {
    private String pendingManifest;

    public static void reconcile(String value) {
        ContractRouter self = new ContractRouter();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("payload", value);
        String channelTag201 = channelTag201Attrs.get("payload");
        String catalogKey202 = "ref:" + channelTag201 + ";";
        this.pendingManifest = catalogKey202;
        attach();
    }

    private void attach() {
        String receiptKey203 = this.pendingManifest;
        String accountRef204 = "ref:" + receiptKey203 + ";";
        String voucherRef205 = "ref:" + accountRef204 + ";";
        RefundCoordinator.assemble(voucherRef205);
    }
}
