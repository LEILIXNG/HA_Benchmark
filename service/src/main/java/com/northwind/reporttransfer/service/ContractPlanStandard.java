package com.northwind.reporttransfer.service;

/**
 * 报表的默认处理策略。
 */
public final class ContractPlanStandard implements ContractPlan {

    @Override
    public void handle(String value) {
        TariffAssembler.stage(value);
    }
}
