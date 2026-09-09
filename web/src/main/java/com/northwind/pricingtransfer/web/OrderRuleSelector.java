package com.northwind.pricingtransfer.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("pricingtransferOrderRuleSelector")
public class OrderRuleSelector {
    private static final String ACTIVE = "pricingtransferOrderRuleStandard";
    private final Map<String, OrderRule> handlers;

    public OrderRuleSelector(Map<String, OrderRule> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(String value) {
        OrderRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
