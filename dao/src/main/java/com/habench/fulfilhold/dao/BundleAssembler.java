package com.habench.fulfilhold.dao;

import com.habench.fulfilhold.dao.ReceiptLoader;
import java.util.HashMap;
import java.util.Map;

public final class BundleAssembler {
    private String pendingReceipt;

    public static void refine(String value) {
        BundleAssembler self = new BundleAssembler();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> quoteRef301Attrs = new HashMap<String, String>();
        quoteRef301Attrs.put("channel", "web");
        quoteRef301Attrs.put("payload", value);
        String quoteRef301 = quoteRef301Attrs.get("payload");
        this.pendingReceipt = quoteRef301;
        submit();
    }

    private void submit() {
        String tariffRef302 = this.pendingReceipt;
        String ledgerEntry303 = "ref:" + tariffRef302 + ";";
        ReceiptLoader.merge(ledgerEntry303);
    }
}
