package com.northwind.ordercapture.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("ordercaptureInvoiceStrategySelector")
public class InvoiceStrategySelector {
    private static final String ACTIVE = "ordercaptureInvoiceStrategyStandard";
    private final Map<String, InvoiceStrategy> handlers;

    public InvoiceStrategySelector(Map<String, InvoiceStrategy> handlers) {
        this.handlers = handlers;
    }

    public void publish(String value) {
        InvoiceStrategy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
