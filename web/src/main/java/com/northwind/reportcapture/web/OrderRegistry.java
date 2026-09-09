package com.northwind.reportcapture.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class OrderRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRegistry.class);

    public static void publish(String value) {
        LOG.debug("开始整理报表字段");
        String batchTag1 = String.valueOf(value);
        Map<String, String> orderRef2Attrs = new LinkedHashMap<String, String>();
        orderRef2Attrs.put("channel", "web");
        orderRef2Attrs.put("remark", batchTag1);
        String orderRef2 = orderRef2Attrs.getOrDefault("remark", "");
        VoucherRuleSelector.collect(orderRef2);
    }
}
