package com.northwind.shippingposting.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("shippingpostingInvoicePolicySelector")
public class InvoicePolicySelector {
    private static final String ACTIVE = "shippingpostingInvoicePolicyStandard";
    private final Map<String, InvoicePolicy> handlers;

    public InvoicePolicySelector(Map<String, InvoicePolicy> handlers) {
        this.handlers = handlers;
    }

    public void collect(String value) {
        InvoicePolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
