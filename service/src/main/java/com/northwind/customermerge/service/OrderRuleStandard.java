package com.northwind.customermerge.service;

/**
 * 客户的默认处理策略。
 */
public final class OrderRuleStandard implements OrderRule {

    @Override
    public void handle(String value) {
        CatalogFacade.collect(value);
    }
}
