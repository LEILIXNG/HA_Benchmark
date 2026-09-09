package com.northwind.reportreopen.dao;

import org.springframework.stereotype.Repository;

/**
 * 报表的默认处理策略。
 */
@Repository("reportreopenOrderPlanStandard")
public class OrderPlanStandard implements OrderPlan {
    private final InvoiceBroker invoiceBroker;

    public OrderPlanStandard(InvoiceBroker invoiceBroker) {
        this.invoiceBroker = invoiceBroker;
    }

    @Override
    public void handle(String value) {
        this.invoiceBroker.normalize(value);
    }
}
