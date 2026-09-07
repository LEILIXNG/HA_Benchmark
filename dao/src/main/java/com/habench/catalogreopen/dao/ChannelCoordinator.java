package com.habench.catalogreopen.dao;

import com.habench.catalogreopen.dao.SessionPolicy;

public final class ChannelCoordinator {

    public static void submit(String value) {
        String voucherRef201 = value;
        SessionPolicy.assemble(voucherRef201);
    }
}
