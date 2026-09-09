package com.northwind.paymentbatch.service;

import org.springframework.stereotype.Service;

/**
 * 支付的默认处理策略。
 */
@Service("paymentbatchSessionPolicyStandard")
public class SessionPolicyStandard implements SessionPolicy {
    private final TariffCoordinator tariffCoordinator;

    public SessionPolicyStandard(TariffCoordinator tariffCoordinator) {
        this.tariffCoordinator = tariffCoordinator;
    }

    @Override
    public void handle(String value) {
        this.tariffCoordinator.stage(value);
    }
}
