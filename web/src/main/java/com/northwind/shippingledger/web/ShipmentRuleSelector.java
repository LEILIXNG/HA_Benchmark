package com.northwind.shippingledger.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 发运处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("shippingledgerShipmentRuleSelector")
public class ShipmentRuleSelector {
    private static final String ACTIVE = "shippingledgerShipmentRuleStandard";
    private final Map<String, ShipmentRule> handlers;

    public ShipmentRuleSelector(Map<String, ShipmentRule> handlers) {
        this.handlers = handlers;
    }

    public void merge(String value) {
        ShipmentRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
