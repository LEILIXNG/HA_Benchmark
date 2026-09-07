package com.habench.paymentreconcile.web;

import com.habench.paymentreconcile.service.ContractAssembler;

public final class RefundCoordinator {

    public static void forward(String value) {
        String manifestKey101 = value;
        ContractAssembler.dispatch(manifestKey101);
    }
}
