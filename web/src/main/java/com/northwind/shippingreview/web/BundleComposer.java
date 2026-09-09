package com.northwind.shippingreview.web;

import com.northwind.shippingreview.service.ShipmentComposer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleComposer {
    private static final Logger LOG = LoggerFactory.getLogger(BundleComposer.class);

    public static void register(String value) {
        LOG.debug("开始整理发运字段");
        StringBuilder catalogKey1Buffer = new StringBuilder("ref:");
        catalogKey1Buffer.append(value).append(";");
        String catalogKey1 = catalogKey1Buffer.toString();
        ShipmentComposer.forward(catalogKey1);
    }
}
