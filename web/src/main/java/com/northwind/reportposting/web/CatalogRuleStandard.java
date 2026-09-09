package com.northwind.reportposting.web;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportpostingCatalogRuleStandard")
public class CatalogRuleStandard implements CatalogRule {
    private final PaymentFacade paymentFacade;

    public CatalogRuleStandard(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @Override
    public void handle(String value) {
        this.paymentFacade.forward(value);
    }
}
