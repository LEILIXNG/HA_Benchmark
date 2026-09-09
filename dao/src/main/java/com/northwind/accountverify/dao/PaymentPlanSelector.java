package com.northwind.accountverify.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("accountverifyPaymentPlanSelector")
public class PaymentPlanSelector {
    private static final String ACTIVE = "accountverifyPaymentPlanStandard";
    private final Map<String, PaymentPlan> handlers;

    public PaymentPlanSelector(Map<String, PaymentPlan> handlers) {
        this.handlers = handlers;
    }

    public void dispatch(String value) {
        PaymentPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
