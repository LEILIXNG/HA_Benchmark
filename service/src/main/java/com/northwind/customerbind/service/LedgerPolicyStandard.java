package com.northwind.customerbind.service;

/**
 * 客户的默认处理策略。
 */
public final class LedgerPolicyStandard implements LedgerPolicy {

    @Override
    public void handle(String value) {
        CatalogService.enrich(value);
    }
}
