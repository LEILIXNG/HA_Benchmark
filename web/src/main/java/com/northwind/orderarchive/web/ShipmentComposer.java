package com.northwind.orderarchive.web;

import com.northwind.orderarchive.service.ChannelService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("orderarchiveShipmentComposer")
public class ShipmentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentComposer.class);
    private final ChannelService channelService;

    public ShipmentComposer(ChannelService channelService) {
        this.channelService = channelService;
    }

    public void publish(String value) {
        LOG.trace("进入订单处理环节");
        List<String> ledgerEntry1Attrs = new ArrayList<String>();
        ledgerEntry1Attrs.add("web");
        ledgerEntry1Attrs.add(value);
        String ledgerEntry1 = ledgerEntry1Attrs.get(1);
        Map<String, String> channelTag2Attrs = new LinkedHashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("remark", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.getOrDefault("remark", "");
        this.channelService.attach(channelTag2);
    }
}
