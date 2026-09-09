package com.northwind.paymentsplit.web;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 支付处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Component("paymentsplitVoucherRuleSelector")
public class VoucherRuleSelector {
    private static final String ACTIVE = "paymentsplitVoucherRuleStandard";
    private final Map<String, VoucherRule> handlers;

    public VoucherRuleSelector(Map<String, VoucherRule> handlers) {
        this.handlers = handlers;
    }

    public void translate(String value) {
        VoucherRule handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
