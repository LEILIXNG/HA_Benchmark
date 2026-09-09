package com.northwind.paymentbatch.service;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 支付处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Service("paymentbatchSessionPolicySelector")
public class SessionPolicySelector {
    private static final String ACTIVE = "paymentbatchSessionPolicyStandard";
    private final Map<String, SessionPolicy> handlers;

    public SessionPolicySelector(Map<String, SessionPolicy> handlers) {
        this.handlers = handlers;
    }

    public void enrich(String value) {
        SessionPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
