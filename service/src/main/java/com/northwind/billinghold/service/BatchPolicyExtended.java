package com.northwind.billinghold.service;

import org.springframework.stereotype.Service;

/**
 * 账务的备用处理策略，当前渠道未启用。
 */
@Service("billingholdBatchPolicyExtended")
public class BatchPolicyExtended implements BatchPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
