package com.habench.fulfilapprove.service;

import com.habench.fulfilapprove.service.ChannelPlanSelector;

public final class CatalogRegistry {

    public static void submit(String value) {
        String receiptKey301 = "ref:" + value + ";";
        String accountRef302 = receiptKey301;
        ChannelPlanSelector.submit(accountRef302);
    }
}
