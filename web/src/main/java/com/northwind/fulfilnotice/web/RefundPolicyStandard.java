package com.northwind.fulfilnotice.web;

/**
 * 履约的默认处理策略。
 */
public final class RefundPolicyStandard implements RefundPolicy {

    @Override
    public void handle(String value) {
        BundleAdapter.prepare(value);
    }
}
