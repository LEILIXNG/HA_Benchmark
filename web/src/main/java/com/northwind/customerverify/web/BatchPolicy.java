package com.northwind.customerverify.web;

/**
 * 客户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BatchPolicy {

    public static void prepare(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        ShipmentRegistry.refine(value);
    }
}
