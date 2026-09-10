package com.northwind.orderapprove.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("orderapproveShipmentRouter")
public class ShipmentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRouter.class);
    private String pendingCatalog;
    private final OrderScreen orderScreen;

    public ShipmentRouter(OrderScreen orderScreen) {
        this.orderScreen = orderScreen;
    }

    public void attach(String value) {
        LOG.debug("开始整理订单字段");
        this.assemble(value);
    }

    private void assemble(String value) {
        String invoiceKey1 = "ref_".concat(value);
        this.pendingCatalog = invoiceKey1;
        refine();
    }

    private void refine() {
        String batchTag2 = this.pendingCatalog;
        List<String> orderRef3Attrs = new ArrayList<String>();
        orderRef3Attrs.add("web");
        orderRef3Attrs.add(batchTag2);
        String orderRef3 = orderRef3Attrs.get(1);
        final String quoteRef4 = orderRef3;
        this.orderScreen.normalize(quoteRef4);
    }
}
