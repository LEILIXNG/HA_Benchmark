package com.northwind.customermerge.service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 客户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogFacade {

    public static void collect(String value) {
        Map<String, String> manifestKey201Attrs = new LinkedHashMap<String, String>();
        manifestKey201Attrs.put("channel", "web");
        manifestKey201Attrs.put("detail", value);
        String manifestKey201 = manifestKey201Attrs.getOrDefault("detail", "");
        StringBuilder invoiceKey202Buffer = new StringBuilder("ref:");
        invoiceKey202Buffer.append(manifestKey201).append(";");
        String invoiceKey202 = invoiceKey202Buffer.toString();
        PaymentGuard.stage(invoiceKey202);
    }
}
