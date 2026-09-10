package com.northwind.orderimport.web;

import com.northwind.orderimport.service.BatchBroker;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class VoucherResolver {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherResolver.class);

    public static void reconcile(String value) {
        LOG.debug("订单流程转下一环节");
        List<String> refundCode101Attrs = new ArrayList<String>();
        refundCode101Attrs.add("web");
        refundCode101Attrs.add(value);
        String refundCode101 = refundCode101Attrs.get(1);
        String shipmentCode102 = "ref_".concat(refundCode101);
        BatchBroker.expand(shipmentCode102);
    }
}
