package com.northwind.billingintake.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BatchBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(BatchBuilder.class);

    public static void expand(String value) {
        LOG.trace("进入账务处理环节");
        List<String> refundCode201Attrs = new ArrayList<String>();
        refundCode201Attrs.add("web");
        refundCode201Attrs.add(value);
        String refundCode201 = refundCode201Attrs.get(1);
        String shipmentCode202 = refundCode201;
        PaymentPolicySelector.expand(shipmentCode202);
    }
}
