package com.habench.fulfildigest.dao;

import com.habench.fulfildigest.dao.VoucherLoader;

public final class LedgerCoordinator {

    public static void stage(String value) {
        String batchTag401 = value;
        String orderRef402 = batchTag401;
        VoucherLoader.assemble(orderRef402);
    }
}
