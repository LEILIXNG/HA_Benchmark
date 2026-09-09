package com.northwind.shippingtransfer.web;

import org.springframework.stereotype.Component;

/**
 * 发运的默认处理策略。
 */
@Component("shippingtransferAccountPlanStandard")
public class AccountPlanStandard implements AccountPlan {
    private final CatalogBroker catalogBroker;

    public AccountPlanStandard(CatalogBroker catalogBroker) {
        this.catalogBroker = catalogBroker;
    }

    @Override
    public void handle(String value) {
        this.catalogBroker.collect(value);
    }
}
