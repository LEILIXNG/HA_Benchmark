package com.northwind.customerrollup.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 客户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("customerrollupShipmentStrategySelector")
public class ShipmentStrategySelector {
    private static final String ACTIVE = "customerrollupShipmentStrategyStandard";
    private final Map<String, ShipmentStrategy> handlers;

    public ShipmentStrategySelector(Map<String, ShipmentStrategy> handlers) {
        this.handlers = handlers;
    }

    public void collect(String value) {
        ShipmentStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
