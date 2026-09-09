package com.northwind.paymenttrace.dao;

import org.springframework.stereotype.Repository;

/**
 * 支付的默认处理策略。
 */
@Repository("paymenttraceOrderStrategyStandard")
public class OrderStrategyStandard implements OrderStrategy {
    private final InvoiceService invoiceService;

    public OrderStrategyStandard(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void handle(String value) {
        this.invoiceService.enrich(value);
    }
}
