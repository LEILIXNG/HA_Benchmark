package com.northwind.pricingsettlequeue.web;

/**
 * 定价的默认处理策略。
 */
public final class VoucherPolicyStandard implements VoucherPolicy {

    @Override
    public void handle(String value) {
        ManifestBuilder.register(value);
    }
}
