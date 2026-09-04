package com.habench.accountrollup.service;

import com.habench.accountrollup.service.PaymentPolicy;

public final class ManifestResolver {

    public static void submit(String value) {
        String accountRef301 = "ref:" + value + ";";
        PaymentPolicy.dispatch(accountRef301);
    }
}
