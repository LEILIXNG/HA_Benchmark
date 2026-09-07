package com.habench.billingreopen.web;

import com.habench.billingreopen.service.SessionNormalizer;
import java.util.HashMap;
import java.util.Map;

public final class CatalogFacade {
    private String pendingChannel;

    public static void dispatch(String value) {
        CatalogFacade self = new CatalogFacade();
        self.normalize(value);
    }

    private void normalize(String value) {
        String catalogKey201 = "ref:" + value + ";";
        Map<String, String> receiptKey202Attrs = new HashMap<String, String>();
        receiptKey202Attrs.put("channel", "web");
        receiptKey202Attrs.put("payload", catalogKey201);
        String receiptKey202 = receiptKey202Attrs.get("payload");
        this.pendingChannel = receiptKey202;
        refine();
    }

    private void refine() {
        String accountRef203 = this.pendingChannel;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        SessionNormalizer.normalize(voucherRef204);
    }
}
