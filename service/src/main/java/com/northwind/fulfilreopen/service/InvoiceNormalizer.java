package com.northwind.fulfilreopen.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class InvoiceNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceNormalizer.class);

    public static void assemble(String value) {
        LOG.debug("履约流程转下一环节");
        String channelTag201 = "ref:" + value + ";";
        ManifestEnricher.resolve(channelTag201);
    }
}
