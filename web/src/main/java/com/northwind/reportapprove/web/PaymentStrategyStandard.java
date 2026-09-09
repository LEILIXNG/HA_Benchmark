package com.northwind.reportapprove.web;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportapprovePaymentStrategyStandard")
public class PaymentStrategyStandard implements PaymentStrategy {
    private final TariffBroker tariffBroker;

    public PaymentStrategyStandard(TariffBroker tariffBroker) {
        this.tariffBroker = tariffBroker;
    }

    @Override
    public void handle(String value) {
        this.tariffBroker.stage(value);
    }
}
