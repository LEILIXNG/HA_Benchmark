package com.habench.catalogsync.web;

import com.habench.catalogsync.service.TariffCollector;

public final class TariffBuilder {

    public static void prepare(String value) {
        String accountRef201 = "ref:" + value + ";";
        String voucherRef202 = "ref:" + accountRef201 + ";";
        TariffCollector.attach(voucherRef202);
    }
}
