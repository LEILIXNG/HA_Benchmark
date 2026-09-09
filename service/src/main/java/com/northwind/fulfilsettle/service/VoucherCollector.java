package com.northwind.fulfilsettle.service;

import com.northwind.fulfilsettle.dao.RefundCoordinator;
import org.springframework.stereotype.Service;

/**
 * 履约明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("fulfilsettleVoucherCollector")
public class VoucherCollector {
    private final RefundCoordinator refundCoordinator;

    public VoucherCollector(RefundCoordinator refundCoordinator) {
        this.refundCoordinator = refundCoordinator;
    }

    public void enrich(String value) {
        String ledgerEntry201 = "ref:" + value + ";";
        this.refundCoordinator.forward(ledgerEntry201);
    }
}
