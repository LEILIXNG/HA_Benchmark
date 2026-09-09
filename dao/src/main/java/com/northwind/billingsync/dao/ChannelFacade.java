package com.northwind.billingsync.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ChannelFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelFacade.class);

    public static void dispatch(String value) {
        LOG.debug("开始整理账务字段");
        String refundCode401 = String.valueOf(value);
        String shipmentCode402 = refundCode401;
        ReceiptGateway.dispatch(shipmentCode402);
    }
}
