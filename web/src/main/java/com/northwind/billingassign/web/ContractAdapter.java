package com.northwind.billingassign.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账务场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ContractAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ContractAdapter.class);

    public static void compose(String value) {
        LOG.trace("进入账务处理环节");
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("detail", value);
        String quoteRef101 = quoteRef101Attrs.get("detail");
        QuoteFetcher.route(quoteRef101);
    }
}
