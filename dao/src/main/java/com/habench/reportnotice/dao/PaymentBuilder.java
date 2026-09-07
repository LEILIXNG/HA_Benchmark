package com.habench.reportnotice.dao;

import com.habench.reportnotice.dao.TariffLoader;

public final class PaymentBuilder {

    public static void route(String value) {
        String quoteRef301 = "ref:" + value + ";";
        String tariffRef302 = quoteRef301;
        TariffLoader.register(tariffRef302);
    }
}
