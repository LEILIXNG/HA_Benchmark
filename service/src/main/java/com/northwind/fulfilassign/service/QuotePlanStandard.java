package com.northwind.fulfilassign.service;

/**
 * 履约的默认处理策略。
 */
public final class QuotePlanStandard implements QuotePlan {

    @Override
    public void handle(String value) {
        AccountFacade.attach(value);
    }
}
