package com.northwind.orderimport.service;

import com.northwind.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherGuard {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherGuard.class);

    public static void enrich(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        BundleExecutor.attach(value);
    }
}
