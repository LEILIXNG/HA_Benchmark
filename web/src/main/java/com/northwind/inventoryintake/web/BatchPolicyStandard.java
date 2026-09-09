package com.northwind.inventoryintake.web;

/**
 * 库存的默认处理策略。
 */
public final class BatchPolicyStandard implements BatchPolicy {

    @Override
    public void handle(String value) {
        ContractEnricher.reconcile(value);
    }
}
