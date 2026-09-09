package com.northwind.customerarchive.service;

import org.springframework.stereotype.Service;

/**
 * 客户的默认处理策略。
 */
@Service("customerarchivePaymentStrategyStandard")
public class PaymentStrategyStandard implements PaymentStrategy {
    private final CatalogFacade catalogFacade;

    public PaymentStrategyStandard(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    @Override
    public void handle(String value) {
        this.catalogFacade.publish(value);
    }
}
