package com.northwind.shippingtransfer.dao;

/**
 * 发运主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class OrderGuard {

    public static void refine(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.toLowerCase().startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        ContractFetcher.submit(value);
    }
}
