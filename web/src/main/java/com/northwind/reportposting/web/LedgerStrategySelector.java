package com.northwind.reportposting.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("reportpostingLedgerStrategySelector")
public class LedgerStrategySelector {
    private static final String ACTIVE = "reportpostingLedgerStrategyStandard";
    private final Map<String, LedgerStrategy> handlers;

    public LedgerStrategySelector(Map<String, LedgerStrategy> handlers) {
        this.handlers = handlers;
    }

    public void publish(String value) {
        LedgerStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
