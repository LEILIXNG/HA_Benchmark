package com.habench.reportreview.dao;

import com.habench.reportreview.dao.SessionLoader;

public final class TariffService {

    public static void publish(String value) {
        String accountRef901 = value;
        SessionLoader.route(accountRef901);
    }
}
