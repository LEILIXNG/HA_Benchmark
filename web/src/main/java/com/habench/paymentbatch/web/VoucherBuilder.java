package com.habench.paymentbatch.web;

import com.habench.paymentbatch.service.ShipmentAssembler;

public final class VoucherBuilder {

    public static void translate(String value) {
        String paymentTag1 = "ref:" + value + ";";
        String refundCode2 = paymentTag1;
        ShipmentAssembler.collect(refundCode2);
    }
}
