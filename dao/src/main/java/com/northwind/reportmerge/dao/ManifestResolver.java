package com.northwind.reportmerge.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 报表受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
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
        shipmentCode201Attrs.put("detail", value);
        String shipmentCode201 = shipmentCode201Attrs.get("detail");
        String manifestKey202 = String.valueOf(shipmentCode201);
        cachedContract = manifestKey202;
        stage();
    }

    private void stage() {
        String invoiceKey203 = cachedContract;
        String batchTag204 = "ref:".concat(invoiceKey203).concat(";");
        this.pendingContract = batchTag204;
        dispatch();
    }

    private void dispatch() {
        String orderRef205 = this.pendingContract;
        Map<String, String> quoteRef206Attrs = new LinkedHashMap<String, String>();
        quoteRef206Attrs.put("channel", "web");
        quoteRef206Attrs.put("remark", orderRef205);
        String quoteRef206 = quoteRef206Attrs.getOrDefault("remark", "");
        String tariffRef207 = String.format("ref:%s;", quoteRef206);
        ContractRepository.reconcile(tariffRef207);
    }
}
