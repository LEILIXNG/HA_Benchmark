package com.habench.inventoryposting.dao;

import com.habench.inventoryposting.dao.ContractGateway;

public final class ChannelFacade {

    public static void expand(String value) {
        String manifestKey301 = value;
        ContractGateway.dispatch(manifestKey301);
    }
}
