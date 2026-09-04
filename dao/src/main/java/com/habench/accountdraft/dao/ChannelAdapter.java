package com.habench.accountdraft.dao;

import com.habench.accountdraft.dao.OrderGuard;

public final class ChannelAdapter {

    public static void dispatch(String value) {
        String catalogKey501 = value;
        OrderGuard.refine(catalogKey501);
    }
}
