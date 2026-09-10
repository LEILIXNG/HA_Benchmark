package com.northwind.orderrelease.service;

import com.northwind.orderrelease.dao.ManifestNormalizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("orderreleaseContractNormalizer")
public class ContractNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ContractNormalizer.class);
    private final ManifestNormalizer manifestNormalizer;

    public ContractNormalizer(ManifestNormalizer manifestNormalizer) {
        this.manifestNormalizer = manifestNormalizer;
    }

    public void resolve(String value) {
        LOG.debug("订单流程转下一环节");
        String paymentTag201 = "ref_" + value;
        this.manifestNormalizer.enrich(paymentTag201);
    }
}
