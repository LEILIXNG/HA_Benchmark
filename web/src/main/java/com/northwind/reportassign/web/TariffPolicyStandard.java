package com.northwind.reportassign.web;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportassignTariffPolicyStandard")
public class TariffPolicyStandard implements TariffPolicy {
    private final OrderResolver orderResolver;

    public TariffPolicyStandard(OrderResolver orderResolver) {
        this.orderResolver = orderResolver;
    }

    @Override
    public void handle(String value) {
        this.orderResolver.attach(value);
    }
}
