package com.northwind.inventoryreconcile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 库存处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("inventoryreconcileShipmentService")
public class ShipmentService {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentService.class);
    private final RefundBuilder refundBuilder;

    public ShipmentService(RefundBuilder refundBuilder) {
        this.refundBuilder = refundBuilder;
    }

    public void collect(String value) {
        LOG.debug("接收到一次库存处理请求");
        String accountRef201 = String.valueOf(value);
        String voucherRef202 = accountRef201;
        this.refundBuilder.prepare(voucherRef202);
    }
}
