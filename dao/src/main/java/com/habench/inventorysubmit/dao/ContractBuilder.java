package com.habench.inventorysubmit.dao;

import com.habench.inventorysubmit.dao.VoucherBroker;

public final class ContractBuilder {

    public static void dispatch(String value) {
        String manifestKey201 = value;
        VoucherBroker.collect(manifestKey201);
    }
}
