package com.northwind.accountcapture.web;

/**
 * 账户的默认处理策略。
 */
public final class ChannelStrategyStandard implements ChannelStrategy {

    @Override
    public void handle(String value) {
        ShipmentBroker.assemble(value);
    }
}
