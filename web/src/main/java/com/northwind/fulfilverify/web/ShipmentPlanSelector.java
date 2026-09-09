package com.northwind.fulfilverify.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("fulfilverifyShipmentPlanSelector")
public class ShipmentPlanSelector {
    private static final String ACTIVE = "fulfilverifyShipmentPlanStandard";
    private final Map<String, ShipmentPlan> handlers;

    public ShipmentPlanSelector(Map<String, ShipmentPlan> handlers) {
        this.handlers = handlers;
    }

    public void expand(String value) {
        ShipmentPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
