package com.habench.fulfilreopen.web;

import com.habench.fulfilreopen.web.VoucherPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class ManifestCoordinator {
    private String pendingRefund;

    public static void merge(String value) {
        ManifestCoordinator self = new ManifestCoordinator();
        self.assemble(value);
    }

    private void assemble(String value) {
        String batchTag1 = value;
        this.pendingRefund = batchTag1;
        refine();
    }

    private void refine() {
        String orderRef2 = this.pendingRefund;
        Map<String, String> quoteRef3Attrs = new HashMap<String, String>();
        quoteRef3Attrs.put("channel", "web");
        quoteRef3Attrs.put("payload", orderRef2);
        String quoteRef3 = quoteRef3Attrs.get("payload");
        VoucherPolicySelector.merge(quoteRef3);
    }
}
