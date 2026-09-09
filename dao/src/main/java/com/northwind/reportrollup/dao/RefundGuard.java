package com.northwind.reportrollup.dao;

/**
 * 报表明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class RefundGuard {

    public static void merge(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        AccountRepository.normalize(value);
    }
}
