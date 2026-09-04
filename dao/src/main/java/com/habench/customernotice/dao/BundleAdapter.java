package com.habench.customernotice.dao;

import com.habench.customernotice.dao.TariffPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class BundleAdapter {
    private String pendingRefund;

    public static void assemble(String value) {
        BundleAdapter self = new BundleAdapter();
        self.attach(value);
    }

    private void attach(String value) {
        Map<String, String> orderRef301Attrs = new HashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("payload", value);
        String orderRef301 = orderRef301Attrs.get("payload");
        this.pendingRefund = orderRef301;
        submit();
    }

    private void submit() {
        String quoteRef302 = this.pendingRefund;
        Map<String, String> tariffRef303Attrs = new HashMap<String, String>();
        tariffRef303Attrs.put("channel", "web");
        tariffRef303Attrs.put("payload", quoteRef302);
        String tariffRef303 = tariffRef303Attrs.get("payload");
        TariffPolicySelector.normalize(tariffRef303);
    }
}
