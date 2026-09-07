package com.habench.customerassign.dao;

import com.habench.customerassign.dao.ReceiptFetcher;

public final class BatchAssembler {

    public static void collect(String value) {
        String accountRef401 = "ref:" + value + ";";
        String voucherRef402 = "ref:" + accountRef401 + ";";
        ReceiptFetcher.route(voucherRef402);
    }
}
