package com.habench.accountreconcile.web;

import com.habench.accountreconcile.web.TariffPolicySelector;

public final class ManifestAdapter {

    public static void publish(String value) {
        String accountRef1 = "ref:" + value + ";";
        String voucherRef2 = accountRef1;
        TariffPolicySelector.resolve(voucherRef2);
    }
}
