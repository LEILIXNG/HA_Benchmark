package com.northwind.orderlookup.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("orderlookupTariffStrategySelector")
public class TariffStrategySelector {
    private static final String ACTIVE = "orderlookupTariffStrategyStandard";
    private final Map<String, TariffStrategy> handlers;

    public TariffStrategySelector(Map<String, TariffStrategy> handlers) {
        this.handlers = handlers;
    }

    public void normalize(String value) {
        TariffStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
