package com.northwind.shippingverify.web;

/**
 * 发运明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderRegistry {

    public static void forward(String value) {
        String channelTag101 = String.valueOf(value);
        String catalogKey102 = channelTag101;
        CatalogGateway.compose(catalogKey102);
    }
}
