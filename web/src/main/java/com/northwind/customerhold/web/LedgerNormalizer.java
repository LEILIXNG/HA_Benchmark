package com.northwind.customerhold.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class LedgerNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerNormalizer.class);
    private static String cachedQuote;

    public static void forward(String value) {
        LOG.debug("客户流程转下一环节");
        String channelTag1 = String.format("ref:%s;", value);
        cachedQuote = channelTag1;
        refine();
    }

    private static void refine() {
        String catalogKey2 = cachedQuote;
        Map<String, String> receiptKey3Attrs = new LinkedHashMap<String, String>();
        receiptKey3Attrs.put("channel", "web");
        receiptKey3Attrs.put("note", catalogKey2);
        String receiptKey3 = receiptKey3Attrs.getOrDefault("note", "");
        TariffBroker2.compose(receiptKey3);
    }
}
