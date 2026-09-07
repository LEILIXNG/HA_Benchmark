package com.habench.ordersync.dao;

import com.habench.ordersync.dao.ManifestFetcher;

public final class ChannelPolicy {

    public static void publish(String value) {
        // 只按名字拒绝 localhost：127.0.0.1、[::1]、十进制 IP 等
        // 回环地址的其他写法一律绕过 —— 无效净化
        if (value.startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        ManifestFetcher.forward(value);
    }
}
