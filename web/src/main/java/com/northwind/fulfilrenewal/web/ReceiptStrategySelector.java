package com.northwind.fulfilrenewal.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("fulfilrenewalReceiptStrategySelector")
public class ReceiptStrategySelector {
    private static final String ACTIVE = "fulfilrenewalReceiptStrategyStandard";
    private final Map<String, ReceiptStrategy> handlers;

    public ReceiptStrategySelector(Map<String, ReceiptStrategy> handlers) {
        this.handlers = handlers;
    }

    public void translate(String value) {
        ReceiptStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
