package com.habench.reportreview.dao;

import com.habench.reportreview.dao.TariffService;

public final class AccountComposer {

    public static void route(String value) {
        String manifestKey801 = "ref:" + value + ";";
        TariffService.publish(manifestKey801);
    }
}
