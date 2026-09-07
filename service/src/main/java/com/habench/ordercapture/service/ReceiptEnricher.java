package com.habench.ordercapture.service;

import com.habench.ordercapture.dao.ShipmentRouter;

public final class ReceiptEnricher {

    public static void publish(String value) {
        String batchTag101 = "ref:" + value + ";";
        String orderRef102 = batchTag101;
        ShipmentRouter.normalize(orderRef102);
    }
}
