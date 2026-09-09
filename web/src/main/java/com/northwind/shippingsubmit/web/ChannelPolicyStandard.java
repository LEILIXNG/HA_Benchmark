package com.northwind.shippingsubmit.web;

/**
 * 发运的默认处理策略。
 */
public final class ChannelPolicyStandard implements ChannelPolicy {

    @Override
    public void handle(String value) {
        TariffEnricher.expand(value);
    }
}
