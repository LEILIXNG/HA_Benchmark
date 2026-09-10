package com.northwind.shippingexport.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BundleTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleTranslator.class);

    public static void expand(String value) {
        LOG.debug("开始整理发运字段");
        String ledgerEntry1 = String.format("ref_%s", value);
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("remark", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("remark");
        ManifestComposer.enrich(channelTag2);
    }
}
