package com.northwind.billingrelease.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账务场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class QuoteNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteNormalizer.class);

    public static void register(String value) {
        LOG.debug("账务流程转下一环节");
        Map<String, String> catalogKey201Attrs = new HashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("detail", value);
        String catalogKey201 = catalogKey201Attrs.get("detail");
        String receiptKey202 = new StringBuilder(catalogKey201).toString();
        ContractBroker.translate(receiptKey202);
    }
}
