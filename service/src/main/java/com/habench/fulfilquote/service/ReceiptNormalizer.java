package com.habench.fulfilquote.service;

import com.habench.fulfilquote.dao.AccountAssembler;

public final class ReceiptNormalizer {

    public static void translate(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        AccountAssembler.route(shipmentCode201);
    }
}
