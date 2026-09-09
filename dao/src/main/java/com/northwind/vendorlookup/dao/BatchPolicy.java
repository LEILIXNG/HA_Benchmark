package com.northwind.vendorlookup.dao;

import com.northwind.platform.ValidationException;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class BatchPolicy {

    public static void submit(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.toLowerCase().startsWith("localhost")) {
            throw new ValidationException("blocked host");
        }
        RefundFetcher.dispatch(value);
    }
}
