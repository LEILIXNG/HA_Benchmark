package com.northwind.inventorygrant.service;

import com.northwind.inventorygrant.dao.ContractCoordinator;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptTranslator {

    public static void translate(String value) {
        String catalogKey201 = String.valueOf(value);
        ContractCoordinator.reconcile(catalogKey201);
    }
}
