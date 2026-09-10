package com.northwind.paymentdraft.service;

import com.northwind.paymentdraft.dao.BatchCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("paymentdraftManifestEnricher")
public class ManifestEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestEnricher.class);
    private final BatchCoordinator batchCoordinator;

    public ManifestEnricher(BatchCoordinator batchCoordinator) {
        this.batchCoordinator = batchCoordinator;
    }

    public void merge(String value) {
        LOG.trace("进入支付处理环节");
        StringBuilder voucherRef201Buffer = new StringBuilder("ref_");
        voucherRef201Buffer.append(value);
        String voucherRef201 = voucherRef201Buffer.toString();
        this.batchCoordinator.enrich(voucherRef201);
    }
}
