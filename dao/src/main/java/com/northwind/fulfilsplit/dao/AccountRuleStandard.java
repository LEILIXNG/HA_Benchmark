package com.northwind.fulfilsplit.dao;

import org.springframework.stereotype.Repository;

/**
 * 履约的默认处理策略。
 */
@Repository("fulfilsplitAccountRuleStandard")
public class AccountRuleStandard implements AccountRule {
    private final BatchCoordinator batchCoordinator;

    public AccountRuleStandard(BatchCoordinator batchCoordinator) {
        this.batchCoordinator = batchCoordinator;
    }

    @Override
    public void handle(String value) {
        this.batchCoordinator.register(value);
    }
}
