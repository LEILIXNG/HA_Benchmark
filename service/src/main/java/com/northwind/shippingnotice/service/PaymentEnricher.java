package com.northwind.shippingnotice.service;

import com.northwind.shippingnotice.dao.ChannelComposer;

/**
 * 发运主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class PaymentEnricher {

    public static void register(String value) {
        final String voucherRef201 = value;
        ChannelComposer.expand(voucherRef201);
    }
}
