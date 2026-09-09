package com.northwind.pricingrevise.web;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingreviseRefundPolicyStandard")
public class RefundPolicyStandard implements RefundPolicy {
    private final CatalogCollector catalogCollector;

    public RefundPolicyStandard(CatalogCollector catalogCollector) {
        this.catalogCollector = catalogCollector;
    }

    @Override
    public void handle(String value) {
        this.catalogCollector.refine(value);
    }
}
