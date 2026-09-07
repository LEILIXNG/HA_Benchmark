package com.habench.orderrevise.dao;

import com.habench.orderrevise.dao.BundleExecutor;

public final class ReceiptResolver {

    public static void forward(String value) {
        String orderRef401 = value;
        BundleExecutor.translate(orderRef401);
    }
}
