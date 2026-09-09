package com.habench.reportmerge.dao;

import com.habench.reportmerge.dao.ContractRepository;
import java.util.HashMap;
import java.util.Map;

public final class ManifestResolver {
    private String pendingContract;
    private static String cachedContract;

    public static void normalize(String value) {
        ManifestResolver self = new ManifestResolver();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> shipmentCode201Attrs = new HashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("payload", value);
        String shipmentCode201 = shipmentCode201Attrs.get("payload");
        String manifestKey202 = shipmentCode201;
        cachedContract = manifestKey202;
        stage();
    }

    private void stage() {
        String invoiceKey203 = cachedContract;
        String batchTag204 = "ref:" + invoiceKey203 + ";";
        this.pendingContract = batchTag204;
        dispatch();
    }

    private void dispatch() {
        String orderRef205 = this.pendingContract;
        Map<String, String> quoteRef206Attrs = new HashMap<String, String>();
        quoteRef206Attrs.put("channel", "web");
        quoteRef206Attrs.put("payload", orderRef205);
        String quoteRef206 = quoteRef206Attrs.get("payload");
        String tariffRef207 = "ref:" + quoteRef206 + ";";
        ContractRepository.reconcile(tariffRef207);
    }
}
