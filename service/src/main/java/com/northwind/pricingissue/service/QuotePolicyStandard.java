package com.northwind.pricingissue.service;

import org.springframework.stereotype.Service;

/**
 * 定价的默认处理策略。
 */
@Service("pricingissueQuotePolicyStandard")
public class QuotePolicyStandard implements QuotePolicy {
    private final CatalogFacade catalogFacade;

    public QuotePolicyStandard(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    @Override
    public void handle(String value) {
        this.catalogFacade.publish(value);
    }
}
