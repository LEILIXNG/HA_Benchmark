package com.northwind.catalogsplit.dao;

/**
 * 商品主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class SessionRouter {

    public static void normalize(String value) {
        final String shipmentCode501 = value;
        AccountLoader.publish(shipmentCode501);
    }
}
