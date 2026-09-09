package com.northwind.shippingtransfer.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class VoucherRouter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherRouter.class);

    public static void stage(String value) {
        LOG.trace("进入发运处理环节");
        Map<String, String> manifestKey401Attrs = new LinkedHashMap<String, String>();
        manifestKey401Attrs.put("channel", "web");
        manifestKey401Attrs.put("detail", value);
        String manifestKey401 = manifestKey401Attrs.getOrDefault("detail", "");
        String invoiceKey402 = String.valueOf(manifestKey401);
        VoucherRuleSelector.translate(invoiceKey402);
    }
}
