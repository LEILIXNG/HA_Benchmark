package com.habench.billingreview.dao;

import com.habench.billingreview.dao.OrderResolver;
import java.util.HashMap;
import java.util.Map;

public final class ManifestRouter {
    private String pendingManifest;

    public static void expand(String value) {
        ManifestRouter self = new ManifestRouter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String catalogKey201 = "ref:" + value + ";";
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        this.pendingManifest = receiptKey202;
        collect();
    }

    private void collect() {
        String accountRef203 = this.pendingManifest;
        Map<String, String> voucherRef204Attrs = new HashMap<String, String>();
        voucherRef204Attrs.put("channel", "web");
        voucherRef204Attrs.put("payload", accountRef203);
        String voucherRef204 = voucherRef204Attrs.get("payload");
        OrderResolver.forward(voucherRef204);
    }
}
