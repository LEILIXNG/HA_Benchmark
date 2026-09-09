package com.northwind.shippingreopen.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("shippingreopenInvoiceRuleSelector")
public class InvoiceRuleSelector {
    private static final String ACTIVE = "shippingreopenInvoiceRuleStandard";
    private final Map<String, InvoiceRule> handlers;

    public InvoiceRuleSelector(Map<String, InvoiceRule> handlers) {
        this.handlers = handlers;
    }

    public void expand(String value) {
        InvoiceRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
