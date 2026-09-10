package com.northwind.vendorreview.service;

import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("vendorreviewOrderFacade")
public class OrderFacade {
    private final VoucherRegistry voucherRegistry;

    public OrderFacade(VoucherRegistry voucherRegistry) {
        this.voucherRegistry = voucherRegistry;
    }

    public void route(String value) {
        StringBuilder voucherRef201Buffer = new StringBuilder("ref_");
        voucherRef201Buffer.append(value);
        String voucherRef201 = voucherRef201Buffer.toString();
        this.voucherRegistry.assemble(voucherRef201);
    }
}
