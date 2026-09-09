package com.northwind.accountrefund.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("accountrefundChannelAdapter")
public class ChannelAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelAdapter.class);

    public void stage(String value) {
        LOG.debug("开始整理账户字段");
        List<String> shipmentCode101Attrs = new ArrayList<String>();
        shipmentCode101Attrs.add("web");
        shipmentCode101Attrs.add(value);
        String shipmentCode101 = shipmentCode101Attrs.get(1);
        VoucherGateway.merge(shipmentCode101);
    }
}
