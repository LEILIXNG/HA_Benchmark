package com.habench.reportreview.service;

import com.habench.reportreview.dao.SessionResolver;

public final class SessionAssembler {

    public static void expand(String value) {
        String accountRef301 = "ref:" + value + ";";
        SessionResolver.dispatch(accountRef301);
    }
}
