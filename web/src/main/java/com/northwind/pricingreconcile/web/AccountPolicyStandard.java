package com.northwind.pricingreconcile.web;

/**
 * 定价的默认处理策略。
 */
public final class AccountPolicyStandard implements AccountPolicy {

    @Override
    public void handle(String value) {
        BatchAssembler.expand(value);
    }
}
