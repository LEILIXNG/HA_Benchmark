package com.northwind.billingrenewal.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ShipmentNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentNormalizer.class);

    public static void merge(String value) {
        LOG.debug("开始整理账务字段");
        InvoiceRepository.attach(value);
    }
}
