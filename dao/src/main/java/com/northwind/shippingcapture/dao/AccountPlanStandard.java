package com.northwind.shippingcapture.dao;

/**
 * 发运的默认处理策略。
 */
public final class AccountPlanStandard implements AccountPlan {

    @Override
    public void handle(String value) {
        BundleComposer.stage(value);
    }
}
