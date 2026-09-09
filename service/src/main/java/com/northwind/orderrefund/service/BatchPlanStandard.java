package com.northwind.orderrefund.service;

import org.springframework.stereotype.Service;

/**
 * 订单的默认处理策略。
 */
@Service("orderrefundBatchPlanStandard")
public class BatchPlanStandard implements BatchPlan {
    private final SessionCoordinator sessionCoordinator;

    public BatchPlanStandard(SessionCoordinator sessionCoordinator) {
        this.sessionCoordinator = sessionCoordinator;
    }

    @Override
    public void handle(String value) {
        this.sessionCoordinator.assemble(value);
    }
}
