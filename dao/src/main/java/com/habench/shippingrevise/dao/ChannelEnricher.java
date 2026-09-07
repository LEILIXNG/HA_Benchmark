package com.habench.shippingrevise.dao;

import com.habench.shippingrevise.dao.OrderRepository;

public final class ChannelEnricher {

    public static void assemble(String value) {
        String invoiceKey601 = value;
        String batchTag602 = invoiceKey601;
        OrderRepository.resolve(batchTag602);
    }
}
