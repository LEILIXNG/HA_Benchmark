package com.northwind.paymenttrace.web;

import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("paymenttraceChannelBuilder")
public class ChannelBuilder {
    private final BatchBroker batchBroker;

    public ChannelBuilder(BatchBroker batchBroker) {
        this.batchBroker = batchBroker;
    }

    public void normalize(String value) {
        String ledgerEntry1 = "ref:" + value + ";";
        StringBuilder channelTag2Buffer = new StringBuilder("ref:");
        channelTag2Buffer.append(ledgerEntry1).append(";");
        String channelTag2 = channelTag2Buffer.toString();
        this.batchBroker.expand(channelTag2);
    }
}
