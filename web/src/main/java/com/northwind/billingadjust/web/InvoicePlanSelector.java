package com.northwind.billingadjust.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("billingadjustInvoicePlanSelector")
public class InvoicePlanSelector {
    private static final String ACTIVE = "billingadjustInvoicePlanStandard";
    private final Map<String, InvoicePlan> handlers;

    public InvoicePlanSelector(Map<String, InvoicePlan> handlers) {
        this.handlers = handlers;
    }

    public void attach(String value) {
        InvoicePlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
