package com.northwind.reportsettle.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class VoucherCollector {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherCollector.class);

    public static void prepare(String value) {
        LOG.debug("报表流程转下一环节");
        Map<String, String> catalogKey101Attrs = new LinkedHashMap<String, String>();
        catalogKey101Attrs.put("channel", "web");
        catalogKey101Attrs.put("detail", value);
        String catalogKey101 = catalogKey101Attrs.getOrDefault("detail", "");
        RefundEnricher.refine(catalogKey101);
    }
}
