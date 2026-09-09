package com.habench.billingsync.dao;

import com.habench.billingsync.dao.ReceiptGateway;

public final class ChannelFacade {

    public static void dispatch(String value) {
        String refundCode401 = value;
        String shipmentCode402 = refundCode401;
        ReceiptGateway.dispatch(shipmentCode402);
    }
}
