package com.northwind.inventoryverify.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderScreen {
    private static final Logger LOG = LoggerFactory.getLogger(OrderScreen.class);

    public static void compose(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        ManifestExecutor.register(value);
    }
}
