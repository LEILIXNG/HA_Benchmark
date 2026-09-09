package com.northwind.orderreconcile.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("orderreconcileTariffStrategySelector")
public class TariffStrategySelector {
    private static final String ACTIVE = "orderreconcileTariffStrategyStandard";
    private final Map<String, TariffStrategy> handlers;

    public TariffStrategySelector(Map<String, TariffStrategy> handlers) {
        this.handlers = handlers;
    }

    public void expand(String value) {
        TariffStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
