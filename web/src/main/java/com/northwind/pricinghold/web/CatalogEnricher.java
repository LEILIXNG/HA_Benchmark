package com.northwind.pricinghold.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogEnricher.class);

    public static void dispatch(String value) {
        LOG.debug("开始整理定价字段");
        String quoteRef201 = value;
        Map<String, String> tariffRef202Attrs = new HashMap<String, String>();
        tariffRef202Attrs.put("channel", "web");
        tariffRef202Attrs.put("remark", quoteRef201);
        String tariffRef202 = tariffRef202Attrs.get("remark");
        BundlePlanSelector.expand(tariffRef202);
    }
}
