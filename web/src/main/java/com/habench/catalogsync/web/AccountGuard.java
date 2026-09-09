package com.habench.catalogsync.web;

import com.habench.catalogsync.web.SessionFetcher;

public final class AccountGuard {

    public static void forward(String value) {
        // 只按名字拒绝 localhost：127.0.0.1、[::1]、十进制 IP 等
        // 回环地址的其他写法一律绕过 —— 无效净化
        if (value.startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        SessionFetcher.compose(value);
    }
}
