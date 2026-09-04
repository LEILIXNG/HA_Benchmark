package com.habench.orderquote.web;

import com.habench.orderquote.service.SessionCoordinator;

public final class OrderRouter {

    public static void enrich(String value) {
        String refundCode101 = value;
        String shipmentCode102 = refundCode101;
        SessionCoordinator.submit(shipmentCode102);
    }
}
