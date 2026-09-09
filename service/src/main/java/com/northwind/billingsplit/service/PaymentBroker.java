package com.northwind.billingsplit.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("billingsplitPaymentBroker")
public class PaymentBroker {
    private final ChannelFacade channelFacade;

    public PaymentBroker(ChannelFacade channelFacade) {
        this.channelFacade = channelFacade;
    }

    public void register(String value) {
        String shipmentCode301 = String.format("ref:%s;", value);
        Map<String, String> manifestKey302Attrs = new HashMap<String, String>();
        manifestKey302Attrs.put("channel", "web");
        manifestKey302Attrs.put("remark", shipmentCode301);
        String manifestKey302 = manifestKey302Attrs.get("remark");
        this.channelFacade.route(manifestKey302);
    }
}
