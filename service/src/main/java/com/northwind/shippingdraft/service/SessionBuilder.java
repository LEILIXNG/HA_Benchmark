package com.northwind.shippingdraft.service;

import com.northwind.shippingdraft.dao.ChannelComposer;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("shippingdraftSessionBuilder")
public class SessionBuilder {
    private final ChannelComposer channelComposer;

    public SessionBuilder(ChannelComposer channelComposer) {
        this.channelComposer = channelComposer;
    }

    public void attach(String value) {
        String accountRef101 = String.format("ref:%s;", value);
        String voucherRef102 = "ref:".concat(accountRef101).concat(";");
        this.channelComposer.register(voucherRef102);
    }
}
