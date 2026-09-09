package com.northwind.inventoryrevise.dao;

/**
 * 库存受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class LedgerValidator {

    public static void normalize(String value) {
        // 历史脚本里带分号会切断参数，先删掉
        String cleaned = value.replace(";", "");
        PaymentExecutor.expand(cleaned);
    }
}
