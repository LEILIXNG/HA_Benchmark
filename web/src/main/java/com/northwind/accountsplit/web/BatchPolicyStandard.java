package com.northwind.accountsplit.web;

import org.springframework.stereotype.Component;

/**
 * 账户的默认处理策略。
 */
@Component("accountsplitBatchPolicyStandard")
public class BatchPolicyStandard implements BatchPolicy {
    private final SessionNormalizer sessionNormalizer;

    public BatchPolicyStandard(SessionNormalizer sessionNormalizer) {
        this.sessionNormalizer = sessionNormalizer;
    }

    @Override
    public void handle(String value) {
        this.sessionNormalizer.register(value);
    }
}
