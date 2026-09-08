package com.habench.shippingquote.web;

import com.habench.shippingquote.web.QuoteFetcher;

public final class BatchValidator {

    public static void refine(String value) {
        // 只按名字拒绝 localhost：127.0.0.1、[::1]、十进制 IP 等
        // 回环地址的其他写法一律绕过 —— 无效净化
        if (value.startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        QuoteFetcher.refine(value);
    }
}
