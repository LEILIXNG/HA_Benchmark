package com.northwind.inventoryledger.dao;

/**
 * 库存主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ManifestBroker {

    public static void dispatch(String value) {
        String batchTag501 = value;
        OrderGateway.compose(batchTag501);
    }
}
