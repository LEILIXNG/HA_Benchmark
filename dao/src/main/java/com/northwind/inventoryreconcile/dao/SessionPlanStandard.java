package com.northwind.inventoryreconcile.dao;

import org.springframework.stereotype.Repository;

/**
 * 库存的默认处理策略。
 */
@Repository("inventoryreconcileSessionPlanStandard")
public class SessionPlanStandard implements SessionPlan {
    private final InvoiceEnricher invoiceEnricher;

    public SessionPlanStandard(InvoiceEnricher invoiceEnricher) {
        this.invoiceEnricher = invoiceEnricher;
    }

    @Override
    public void handle(String value) {
        this.invoiceEnricher.stage(value);
    }
}
