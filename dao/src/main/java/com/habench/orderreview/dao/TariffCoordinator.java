package com.habench.orderreview.dao;

import com.habench.orderreview.dao.ReceiptPlanSelector;

public final class TariffCoordinator {

    public static void merge(String value) {
        String receiptKey301 = value;
        ReceiptPlanSelector.compose(receiptKey301);
    }
}
