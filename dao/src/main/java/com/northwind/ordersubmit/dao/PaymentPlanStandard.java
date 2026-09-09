package com.northwind.ordersubmit.dao;

import org.springframework.stereotype.Repository;

/**
 * 订单的默认处理策略。
 */
@Repository("ordersubmitPaymentPlanStandard")
public class PaymentPlanStandard implements PaymentPlan {
    private final SessionBuilder sessionBuilder;

    public PaymentPlanStandard(SessionBuilder sessionBuilder) {
        this.sessionBuilder = sessionBuilder;
    }

    @Override
    public void handle(String value) {
        this.sessionBuilder.enrich(value);
    }
}
