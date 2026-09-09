package com.northwind.ordermerge.web;

import org.springframework.stereotype.Component;

/**
 * 订单的默认处理策略。
 */
@Component("ordermergeTariffPlanStandard")
public class TariffPlanStandard implements TariffPlan {
    private final TariffComposer tariffComposer;

    public TariffPlanStandard(TariffComposer tariffComposer) {
        this.tariffComposer = tariffComposer;
    }

    @Override
    public void handle(String value) {
        this.tariffComposer.publish(value);
    }
}
