package com.northwind.pricinggrant.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("pricinggrantRefundBroker")
public class RefundBroker {
    private final ChannelFacade channelFacade;

    public RefundBroker(ChannelFacade channelFacade) {
        this.channelFacade = channelFacade;
    }

    public void reconcile(String value) {
        String refundCode1 = "ref:".concat(value).concat(";");
        Map<String, String> shipmentCode2Attrs = new LinkedHashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("remark", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.getOrDefault("remark", "");
        this.channelFacade.enrich(shipmentCode2);
    }
}
