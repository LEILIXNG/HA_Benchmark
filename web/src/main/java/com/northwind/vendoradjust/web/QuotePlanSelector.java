package com.northwind.vendoradjust.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 供应商处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("vendoradjustQuotePlanSelector")
public class QuotePlanSelector {
    private static final String ACTIVE = "vendoradjustQuotePlanStandard";
    private final Map<String, QuotePlan> handlers;

    public QuotePlanSelector(Map<String, QuotePlan> handlers) {
        this.handlers = handlers;
    }

    public void reconcile(String value) {
        QuotePlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
