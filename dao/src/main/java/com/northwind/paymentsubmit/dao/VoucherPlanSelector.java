package com.northwind.paymentsubmit.dao;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("paymentsubmitVoucherPlanSelector")
public class VoucherPlanSelector {
    private static final String ACTIVE = "paymentsubmitVoucherPlanStandard";
    private final Map<String, VoucherPlan> handlers;

    public VoucherPlanSelector(Map<String, VoucherPlan> handlers) {
        this.handlers = handlers;
    }

    public void merge(String value) {
        VoucherPlan handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
