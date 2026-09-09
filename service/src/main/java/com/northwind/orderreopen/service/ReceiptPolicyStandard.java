package com.northwind.orderreopen.service;

/**
 * 订单的默认处理策略。
 */
public final class ReceiptPolicyStandard implements ReceiptPolicy {

    @Override
    public void handle(String value) {
        AccountNormalizer.merge(value);
    }
}
