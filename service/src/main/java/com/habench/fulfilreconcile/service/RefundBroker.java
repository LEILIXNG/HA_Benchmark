package com.habench.fulfilreconcile.service;

import com.habench.fulfilreconcile.service.VoucherStrategySelector;

public final class RefundBroker {

    public static void normalize(String value) {
        VoucherStrategySelector.compose(value);
    }
}
