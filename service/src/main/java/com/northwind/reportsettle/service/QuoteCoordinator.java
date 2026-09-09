package com.northwind.reportsettle.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 报表主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class QuoteCoordinator {

    public static void attach(String value) {
        String refundCode301 = new StringBuilder(value).toString();
        List<String> shipmentCode302Attrs = new ArrayList<String>();
        shipmentCode302Attrs.add("web");
        shipmentCode302Attrs.add(refundCode301);
        String shipmentCode302 = shipmentCode302Attrs.get(1);
        ChannelRepository.translate(shipmentCode302);
    }
}
