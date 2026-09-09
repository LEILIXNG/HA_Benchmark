package com.habench.vendorlookup.dao;

import com.habench.vendorlookup.dao.RefundFetcher;

public final class BatchPolicy {

    public static void submit(String value) {
        // 只按名字拒绝 localhost：127.0.0.1、[::1]、十进制 IP 等
        // 回环地址的其他写法一律绕过 —— 无效净化
        if (value.startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        RefundFetcher.dispatch(value);
    }
}
