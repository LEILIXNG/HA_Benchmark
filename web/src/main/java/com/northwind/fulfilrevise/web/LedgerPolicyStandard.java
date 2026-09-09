package com.northwind.fulfilrevise.web;

import org.springframework.stereotype.Component;

/**
 * 履约的默认处理策略。
 */
@Component("fulfilreviseLedgerPolicyStandard")
public class LedgerPolicyStandard implements LedgerPolicy {
    private final OrderEnricher orderEnricher;

    public LedgerPolicyStandard(OrderEnricher orderEnricher) {
        this.orderEnricher = orderEnricher;
    }

    @Override
    public void handle(String value) {
        this.orderEnricher.expand(value);
    }
}
