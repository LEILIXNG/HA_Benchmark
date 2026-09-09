package com.northwind.paymentintake.dao;

import org.springframework.stereotype.Repository;

/**
 * 支付的默认处理策略。
 */
@Repository("paymentintakeQuotePolicyStandard")
public class QuotePolicyStandard implements QuotePolicy {
    private final BatchFacade batchFacade;

    public QuotePolicyStandard(BatchFacade batchFacade) {
        this.batchFacade = batchFacade;
    }

    @Override
    public void handle(String value) {
        this.batchFacade.register(value);
    }
}
