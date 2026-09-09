package com.northwind.orderadjust.dao;

/**
 * 订单处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class CatalogScreen {

    public static void submit(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.indexOf("localhost") == 0) {
            throw new IllegalArgumentException("blocked host");
        }
        BundleFetcher.dispatch(value);
    }
}
