package com.northwind.customerreview.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("customerreviewReceiptRuleSelector")
public class ReceiptRuleSelector {
    private static final String ACTIVE = "customerreviewReceiptRuleStandard";
    private final Map<String, ReceiptRule> handlers;

    public ReceiptRuleSelector(Map<String, ReceiptRule> handlers) {
        this.handlers = handlers;
    }

    public void prepare(String value) {
        ReceiptRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
