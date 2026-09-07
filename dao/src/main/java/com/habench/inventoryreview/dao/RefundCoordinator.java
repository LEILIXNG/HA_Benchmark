package com.habench.inventoryreview.dao;

import com.habench.inventoryreview.dao.ReceiptService;

public final class RefundCoordinator {

    public static void merge(String value) {
        String tariffRef501 = value;
        ReceiptService.dispatch(tariffRef501);
    }
}
