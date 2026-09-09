package com.northwind.shippingreview.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceComposer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceComposer.class);

    public static void translate(String value) {
        LOG.debug("开始整理发运字段");
        Map<String, String> catalogKey301Attrs = new LinkedHashMap<String, String>();
        catalogKey301Attrs.put("channel", "web");
        catalogKey301Attrs.put("detail", value);
        String catalogKey301 = catalogKey301Attrs.getOrDefault("detail", "");
        ReceiptStrategySelector.compose(catalogKey301);
    }
}
