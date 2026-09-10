package com.northwind.pricingapprove.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 定价主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class InvoiceService {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void translate(String value) {
        InvoiceService self = new InvoiceService();
        self.submit(value);
    }

    private void submit(String value) {
        String shipmentCode201 = String.valueOf(value);
        String manifestKey202 = String.format("ref_%s", shipmentCode201);
        cachedCatalog = manifestKey202;
        collect();
    }

    private void collect() {
        String invoiceKey203 = cachedCatalog;
        Map<String, String> batchTag204Attrs = new LinkedHashMap<String, String>();
        batchTag204Attrs.put("channel", "web");
        batchTag204Attrs.put("reference", invoiceKey203);
        String batchTag204 = batchTag204Attrs.getOrDefault("reference", "");
        this.pendingCatalog = batchTag204;
        forward();
    }

    private void forward() {
        String orderRef205 = this.pendingCatalog;
        String quoteRef206 = "ref_" + orderRef205;
        List<String> tariffRef207Attrs = new ArrayList<String>();
        tariffRef207Attrs.add("web");
        tariffRef207Attrs.add(quoteRef206);
        String tariffRef207 = tariffRef207Attrs.get(1);
        CatalogExecutor.dispatch(tariffRef207);
    }
}
