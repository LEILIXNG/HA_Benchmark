package com.northwind.reportquote.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("reportquoteQuotePlanSelector")
public class QuotePlanSelector {
    private static final String ACTIVE = "reportquoteQuotePlanStandard";
    private final Map<String, QuotePlan> handlers;

    public QuotePlanSelector(Map<String, QuotePlan> handlers) {
        this.handlers = handlers;
    }

    public void compose(String value) {
        QuotePlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
