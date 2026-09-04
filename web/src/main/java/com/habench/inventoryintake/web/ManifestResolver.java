package com.habench.inventoryintake.web;

import com.habench.inventoryintake.service.AccountService;

public final class ManifestResolver {

    public static void prepare(String value) {
        String channelTag201 = "ref:" + value + ";";
        AccountService.compose(channelTag201);
    }
}
