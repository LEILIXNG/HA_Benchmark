package com.northwind.reportrefund.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向报表场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class LedgerRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerRegistry.class);
    private String pendingTariff;

    public static void submit(String value) {
        LOG.debug("接收到一次报表处理请求");
        LedgerRegistry self = new LedgerRegistry();
        self.forward(value);
    }

    private void forward(String value) {
        StringBuilder shipmentCode401Buffer = new StringBuilder("ref_");
        shipmentCode401Buffer.append(value);
        String shipmentCode401 = shipmentCode401Buffer.toString();
        String manifestKey402 = String.valueOf(shipmentCode401);
        this.pendingTariff = manifestKey402;
        prepare();
    }

    private void prepare() {
        String invoiceKey403 = this.pendingTariff;
        String batchTag404 = new StringBuilder(invoiceKey403).toString();
        String orderRef405 = "ref_".concat(batchTag404);
        OrderPolicySelector.prepare(orderRef405);
    }
}
