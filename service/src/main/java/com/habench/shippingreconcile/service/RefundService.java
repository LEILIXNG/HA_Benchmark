package com.habench.shippingreconcile.service;

import com.habench.shippingreconcile.service.AccountRepository;

public final class RefundService {

    public static void submit(String value) {
        String shipmentCode101 = value;
        String manifestKey102 = shipmentCode101;
        AccountRepository.submit(manifestKey102);
    }
}
