package com.northwind.reportsync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class CatalogAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogAdapter.class);
    private String pendingRefund;

    public static void expand(String value) {
        LOG.debug("开始整理报表字段");
        CatalogAdapter self = new CatalogAdapter();
        self.prepare(value);
    }

    private void prepare(String value) {
        String paymentTag101 = String.format("ref_%s", value);
        String refundCode102 = "ref_".concat(paymentTag101);
        this.pendingRefund = refundCode102;
        refine();
    }

    private void refine() {
        String shipmentCode103 = this.pendingRefund;
        final String manifestKey104 = shipmentCode103;
        QuotePlanSelector.expand(manifestKey104);
    }
}
