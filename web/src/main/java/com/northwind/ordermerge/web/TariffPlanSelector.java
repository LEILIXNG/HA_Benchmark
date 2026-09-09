package com.northwind.ordermerge.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("ordermergeTariffPlanSelector")
public class TariffPlanSelector {
    private static final String ACTIVE = "ordermergeTariffPlanStandard";
    private final Map<String, TariffPlan> handlers;

    public TariffPlanSelector(Map<String, TariffPlan> handlers) {
        this.handlers = handlers;
    }

    public void expand(String value) {
        TariffPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
