package com.northwind.pricingdispatch.service;

import com.northwind.pricingdispatch.dao.ManifestAssembler;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定价处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class VoucherComposer {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherComposer.class);

    public static void forward(String value) {
        LOG.debug("接收到一次定价处理请求");
        Map<String, String> manifestKey301Attrs = new LinkedHashMap<String, String>();
        manifestKey301Attrs.put("channel", "web");
        manifestKey301Attrs.put("detail", value);
        String manifestKey301 = manifestKey301Attrs.getOrDefault("detail", "");
        String invoiceKey302 = new StringBuilder(manifestKey301).toString();
        ManifestAssembler.refine(invoiceKey302);
    }
}
