package com.habench.customerbind.dao;

import com.habench.customerbind.dao.ReceiptFetcher;

public final class BatchAssembler {

    public static void collect(String value) {
        String accountRef401 = "ref:" + value + ";";
        String voucherRef402 = "ref:" + accountRef401 + ";";
        ReceiptFetcher.route(voucherRef402);
    }
}
