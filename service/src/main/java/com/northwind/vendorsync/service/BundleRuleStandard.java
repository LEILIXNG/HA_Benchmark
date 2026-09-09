package com.northwind.vendorsync.service;

/**
 * 供应商的默认处理策略。
 */
public final class BundleRuleStandard implements BundleRule {

    @Override
    public void handle(String value) {
        AccountAdapter.assemble(value);
    }
}
