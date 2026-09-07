package com.habench.inventoryissue.dao;

import com.habench.inventoryissue.dao.OrderAssembler;

public final class BatchRouter {

    public static void assemble(String value) {
        String voucherRef401 = "ref:" + value + ";";
        OrderAssembler.translate(voucherRef401);
    }
}
