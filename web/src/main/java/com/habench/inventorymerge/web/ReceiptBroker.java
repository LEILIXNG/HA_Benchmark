package com.habench.inventorymerge.web;

import com.habench.inventorymerge.web.OrderRepository;

public final class ReceiptBroker {

    public static void forward(String value) {
        String orderRef201 = value;
        OrderRepository.normalize(orderRef201);
    }
}
