package com.habench.pricingquote.service;

import com.habench.pricingquote.service.OrderRepository;

public final class ChannelTranslator {

    public static void forward(String value) {
        String catalogKey301 = "ref:" + value + ";";
        String receiptKey302 = catalogKey301;
        OrderRepository.enrich(receiptKey302);
    }
}
