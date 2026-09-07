package com.habench.paymenttrace.dao;

import com.habench.paymenttrace.dao.OrderStrategySelector;

public final class AccountCoordinator {

    public static void assemble(String value) {
        String ledgerEntry301 = value;
        OrderStrategySelector.stage(ledgerEntry301);
    }
}
