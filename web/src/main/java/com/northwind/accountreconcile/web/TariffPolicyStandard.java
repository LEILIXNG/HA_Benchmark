package com.northwind.accountreconcile.web;

import org.springframework.stereotype.Component;

/**
 * 账户的默认处理策略。
 */
@Component("accountreconcileTariffPolicyStandard")
public class TariffPolicyStandard implements TariffPolicy {
    private final ChannelBuilder channelBuilder;

    public TariffPolicyStandard(ChannelBuilder channelBuilder) {
        this.channelBuilder = channelBuilder;
    }

    @Override
    public void handle(String value) {
        this.channelBuilder.translate(value);
    }
}
