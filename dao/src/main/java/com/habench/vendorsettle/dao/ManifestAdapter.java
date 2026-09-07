package com.habench.vendorsettle.dao;

import com.habench.vendorsettle.dao.LedgerRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestAdapter {
    private String pendingLedger;

    public static void register(String value) {
        ManifestAdapter self = new ManifestAdapter();
        self.collect(value);
    }

    private void collect(String value) {
        String shipmentCode201 = value;
        Map<String, String> manifestKey202Attrs = new HashMap<String, String>();
        manifestKey202Attrs.put("channel", "web");
        manifestKey202Attrs.put("payload", shipmentCode201);
        String manifestKey202 = manifestKey202Attrs.get("payload");
        this.pendingLedger = manifestKey202;
        reconcile();
    }

    private void reconcile() {
        String invoiceKey203 = this.pendingLedger;
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        String orderRef205 = "ref:" + batchTag204 + ";";
        LedgerRepository.dispatch(orderRef205);
    }
}
