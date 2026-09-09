package com.northwind.fulfilverify.web;

import org.springframework.stereotype.Component;

/**
 * 履约的默认处理策略。
 */
@Component("fulfilverifyShipmentPlanStandard")
public class ShipmentPlanStandard implements ShipmentPlan {
    private final InvoiceService invoiceService;

    public ShipmentPlanStandard(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void handle(String value) {
        this.invoiceService.normalize(value);
    }
}
