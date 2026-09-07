package com.habench.reportreview.dao;

import com.habench.reportreview.dao.TariffService2;

public final class SessionResolver {

    public static void dispatch(String value) {
        String tariffRef401 = value;
        TariffService2.collect(tariffRef401);
    }
}
