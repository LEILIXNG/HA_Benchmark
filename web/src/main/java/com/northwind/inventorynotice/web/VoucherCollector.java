package com.northwind.inventorynotice.web;

import com.northwind.inventorynotice.service.ShipmentAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class VoucherCollector {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherCollector.class);

    public static void prepare(String value) {
        LOG.debug("开始整理库存字段");
        String voucherRef301 = String.format("ref_%s", value);
        ShipmentAssembler.merge(voucherRef301);
    }
}
