package com.northwind.accountsync.service;

import com.northwind.platform.ValidationException;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class CatalogGuard {

    public static void forward(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.toLowerCase().startsWith("localhost")) {
            throw new ValidationException("blocked host");
        }
        RefundFetcher.refine(value);
    }
}
