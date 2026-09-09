package com.northwind.ordersync.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("ordersyncBatchRuleSelector")
public class BatchRuleSelector {
    private static final String ACTIVE = "ordersyncBatchRuleStandard";
    private final Map<String, BatchRule> handlers;

    public BatchRuleSelector(Map<String, BatchRule> handlers) {
        this.handlers = handlers;
    }

    public void publish(String value) {
        BatchRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
