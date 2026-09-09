package com.northwind.paymentdispatch.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 支付处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("paymentdispatchLedgerPlanSelector")
public class LedgerPlanSelector {
    private static final String ACTIVE = "paymentdispatchLedgerPlanStandard";
    private final Map<String, LedgerPlan> handlers;

    public LedgerPlanSelector(Map<String, LedgerPlan> handlers) {
        this.handlers = handlers;
    }

    public void enrich(String value) {
        LedgerPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
