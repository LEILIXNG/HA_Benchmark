package com.northwind.shippingreconcile.dao;

import org.springframework.stereotype.Repository;

/**
 * 发运的默认处理策略。
 */
@Repository("shippingreconcileInvoiceRuleStandard")
public class InvoiceRuleStandard implements InvoiceRule {
    private final QuoteRouter quoteRouter;

    public InvoiceRuleStandard(QuoteRouter quoteRouter) {
        this.quoteRouter = quoteRouter;
    }

    @Override
    public void handle(String value) {
        this.quoteRouter.expand(value);
    }
}
