package com.northwind.billingreconcile.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("billingreconcileRefundStrategySelector")
public class RefundStrategySelector {
    private static final String ACTIVE = "billingreconcileRefundStrategyStandard";
    private final Map<String, RefundStrategy> handlers;

    public RefundStrategySelector(Map<String, RefundStrategy> handlers) {
        this.handlers = handlers;
    }

    public void publish(String value) {
        RefundStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
