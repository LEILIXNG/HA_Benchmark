package com.northwind.shippingimport.service;

/**
 * 发运明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class VoucherGuard {

    public static void stage(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.toLowerCase().startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        CatalogFetcher.merge(value);
    }
}
