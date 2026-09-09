package com.northwind.inventoryassign.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(AccountEnricher.class);

    public static void collect(String value) {
        LOG.debug("库存流程转下一环节");
        String refundCode201 = String.valueOf(value);
        List<String> shipmentCode202Attrs = new ArrayList<String>();
        shipmentCode202Attrs.add("web");
        shipmentCode202Attrs.add(refundCode201);
        String shipmentCode202 = shipmentCode202Attrs.get(1);
        ManifestExecutor.reconcile(shipmentCode202);
    }
}
