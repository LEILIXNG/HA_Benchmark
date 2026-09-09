package com.northwind.reportverify.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 报表处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class QuoteAdapter {
    private static String cachedAccount;

    public static void submit(String value) {
        Map<String, String> shipmentCode301Attrs = new LinkedHashMap<String, String>();
        shipmentCode301Attrs.put("channel", "web");
        shipmentCode301Attrs.put("detail", value);
        String shipmentCode301 = shipmentCode301Attrs.getOrDefault("detail", "");
        cachedAccount = shipmentCode301;
        assemble();
    }

    private static void assemble() {
        String manifestKey302 = cachedAccount;
        String invoiceKey303 = String.format("ref:%s;", manifestKey302);
        cachedAccount = invoiceKey303;
        resolve();
    }

    private static void resolve() {
        String batchTag304 = cachedAccount;
        String orderRef305 = "ref:" + batchTag304 + ";";
        String quoteRef306 = orderRef305;
        cachedAccount = quoteRef306;
        register();
    }

    private static void register() {
        String tariffRef307 = cachedAccount;
        Map<String, String> ledgerEntry308Attrs = new HashMap<String, String>();
        ledgerEntry308Attrs.put("channel", "web");
        ledgerEntry308Attrs.put("reference", tariffRef307);
        String ledgerEntry308 = ledgerEntry308Attrs.get("reference");
        final String channelTag309 = ledgerEntry308;
        AccountGateway.attach(channelTag309);
    }
}
