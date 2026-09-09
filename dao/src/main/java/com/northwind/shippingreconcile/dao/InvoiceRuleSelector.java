package com.northwind.shippingreconcile.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 发运处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("shippingreconcileInvoiceRuleSelector")
public class InvoiceRuleSelector {
    private static final String ACTIVE = "shippingreconcileInvoiceRuleStandard";
    private final Map<String, InvoiceRule> handlers;

    public InvoiceRuleSelector(Map<String, InvoiceRule> handlers) {
        this.handlers = handlers;
    }

    public void compose(String value) {
        InvoiceRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
