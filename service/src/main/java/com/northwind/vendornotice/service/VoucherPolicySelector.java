package com.northwind.vendornotice.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 供应商处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("vendornoticeVoucherPolicySelector")
public class VoucherPolicySelector {
    private static final String ACTIVE = "vendornoticeVoucherPolicyStandard";
    private final Map<String, VoucherPolicy> handlers;

    public VoucherPolicySelector(Map<String, VoucherPolicy> handlers) {
        this.handlers = handlers;
    }

    public void enrich(String value) {
        VoucherPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
