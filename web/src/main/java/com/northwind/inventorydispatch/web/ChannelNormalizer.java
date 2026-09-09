package com.northwind.inventorydispatch.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelNormalizer.class);

    public static void refine(String value) {
        LOG.debug("库存流程转下一环节");
        String receiptKey101 = String.valueOf(value);
        Map<String, String> accountRef102Attrs = new LinkedHashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("remark", receiptKey101);
        String accountRef102 = accountRef102Attrs.getOrDefault("remark", "");
        QuotePlanSelector.register(accountRef102);
    }
}
