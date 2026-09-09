package com.northwind.fulfilbind.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 履约受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BatchRegistry {
    private String pendingCatalog;
    private static String cachedCatalog;

    public static void refine(String value) {
        BatchRegistry self = new BatchRegistry();
        self.assemble(value);
    }

    private void assemble(String value) {
        List<String> orderRef301Attrs = new ArrayList<String>();
        orderRef301Attrs.add("web");
        orderRef301Attrs.add(value);
        String orderRef301 = orderRef301Attrs.get(1);
        String quoteRef302 = String.valueOf(orderRef301);
        cachedCatalog = quoteRef302;
        publish();
    }

    private void publish() {
        String tariffRef303 = cachedCatalog;
        Map<String, String> ledgerEntry304Attrs = new HashMap<String, String>();
        ledgerEntry304Attrs.put("channel", "web");
        ledgerEntry304Attrs.put("reference", tariffRef303);
        String ledgerEntry304 = ledgerEntry304Attrs.get("reference");
        this.pendingCatalog = ledgerEntry304;
        merge();
    }

    private void merge() {
        String channelTag305 = this.pendingCatalog;
        Map<String, String> catalogKey306Attrs = new LinkedHashMap<String, String>();
        catalogKey306Attrs.put("channel", "web");
        catalogKey306Attrs.put("remark", channelTag305);
        String catalogKey306 = catalogKey306Attrs.getOrDefault("remark", "");
        final String receiptKey307 = catalogKey306;
        this.pendingCatalog = receiptKey307;
        stage();
    }

    private void stage() {
        String accountRef308 = this.pendingCatalog;
        String voucherRef309 = "ref:" + accountRef308 + ";";
        String paymentTag310 = String.format("ref:%s;", voucherRef309);
        CatalogEvaluator.register(paymentTag310);
    }
}
