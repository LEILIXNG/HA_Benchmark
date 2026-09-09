package com.northwind.catalogbind.service;

import com.northwind.catalogbind.dao.ShipmentRouter;
import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("catalogbindRefundResolver")
public class RefundResolver {
    private String pendingTariff;
    private final ShipmentRouter shipmentRouter;

    public RefundResolver(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    public void expand(String value) {
        this.submit(value);
    }

    private void submit(String value) {
        String quoteRef101 = "ref:" + value + ";";
        StringBuilder tariffRef102Buffer = new StringBuilder("ref:");
        tariffRef102Buffer.append(quoteRef101).append(";");
        String tariffRef102 = tariffRef102Buffer.toString();
        this.pendingTariff = tariffRef102;
        publish();
    }

    private void publish() {
        String ledgerEntry103 = this.pendingTariff;
        String channelTag104 = "ref:".concat(ledgerEntry103).concat(";");
        this.shipmentRouter.attach(channelTag104);
    }
}
