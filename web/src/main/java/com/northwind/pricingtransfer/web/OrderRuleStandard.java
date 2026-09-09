package com.northwind.pricingtransfer.web;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingtransferOrderRuleStandard")
public class OrderRuleStandard implements OrderRule {
    private final InvoiceRouter invoiceRouter;

    public OrderRuleStandard(InvoiceRouter invoiceRouter) {
        this.invoiceRouter = invoiceRouter;
    }

    @Override
    public void handle(String value) {
        this.invoiceRouter.publish(value);
    }
}
