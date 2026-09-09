package com.northwind.catalogtransfer.web;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogtransferRefundRuleStandard")
public class RefundRuleStandard implements RefundRule {
    private final CatalogCoordinator catalogCoordinator;

    public RefundRuleStandard(CatalogCoordinator catalogCoordinator) {
        this.catalogCoordinator = catalogCoordinator;
    }

    @Override
    public void handle(String value) {
        this.catalogCoordinator.prepare(value);
    }
}
