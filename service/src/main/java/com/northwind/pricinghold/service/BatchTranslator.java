package com.northwind.pricinghold.service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BatchTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BatchTranslator.class);

    public static void merge(String value) {
        LOG.debug("开始整理定价字段");
        Map<String, String> receiptKey401Attrs = new HashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("detail", value);
        String receiptKey401 = receiptKey401Attrs.get("detail");
        VoucherExecutor.stage(receiptKey401);
    }
}
