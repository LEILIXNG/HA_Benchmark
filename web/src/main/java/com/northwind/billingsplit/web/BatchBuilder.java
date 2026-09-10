package com.northwind.billingsplit.web;

import org.springframework.stereotype.Component;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("billingsplitBatchBuilder")
public class BatchBuilder {
    private final ChannelStrategySelector channelStrategySelector;

    public BatchBuilder(ChannelStrategySelector channelStrategySelector) {
        this.channelStrategySelector = channelStrategySelector;
    }

    public void normalize(String value) {
        String shipmentCode1 = "ref_".concat(value);
        String manifestKey2 = String.format("ref_%s", shipmentCode1);
        this.channelStrategySelector.resolve(manifestKey2);
    }
}
