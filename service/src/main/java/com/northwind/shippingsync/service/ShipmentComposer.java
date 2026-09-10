package com.northwind.shippingsync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ShipmentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentComposer.class);
    private String pendingTariff;

    public static void forward(String value) {
        LOG.trace("进入发运处理环节");
        ShipmentComposer self = new ShipmentComposer();
        self.collect(value);
    }

    private void collect(String value) {
        String ledgerEntry101 = String.valueOf(value);
        this.pendingTariff = ledgerEntry101;
        compose();
    }

    private void compose() {
        String channelTag102 = this.pendingTariff;
        String catalogKey103 = "ref_" + channelTag102;
        String receiptKey104 = "ref_".concat(catalogKey103);
        TariffEvaluator.stage(receiptKey104);
    }
}
