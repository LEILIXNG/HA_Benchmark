package com.northwind.vendorarchive.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("vendorarchiveAccountStrategySelector")
public class AccountStrategySelector {
    private static final String ACTIVE = "vendorarchiveAccountStrategyStandard";
    private final Map<String, AccountStrategy> handlers;

    public AccountStrategySelector(Map<String, AccountStrategy> handlers) {
        this.handlers = handlers;
    }

    public void attach(String value) {
        AccountStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
