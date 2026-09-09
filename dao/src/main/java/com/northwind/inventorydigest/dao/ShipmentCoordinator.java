package com.northwind.inventorydigest.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("inventorydigestShipmentCoordinator")
public class ShipmentCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentCoordinator.class);
    private String pendingAccount;
    private static String cachedAccount;
    private final AccountEvaluator accountEvaluator;

    public ShipmentCoordinator(AccountEvaluator accountEvaluator) {
        this.accountEvaluator = accountEvaluator;
    }

    public void dispatch(String value) {
        LOG.debug("开始整理库存字段");
        this.stage(value);
    }

    private void stage(String value) {
        String shipmentCode201 = new StringBuilder(value).toString();
        StringBuilder manifestKey202Buffer = new StringBuilder("ref:");
        manifestKey202Buffer.append(shipmentCode201).append(";");
        String manifestKey202 = manifestKey202Buffer.toString();
        cachedAccount = manifestKey202;
        publish();
    }

    private void publish() {
        String invoiceKey203 = cachedAccount;
        String batchTag204 = "ref:".concat(invoiceKey203).concat(";");
        Map<String, String> orderRef205Attrs = new HashMap<String, String>();
        orderRef205Attrs.put("channel", "web");
        orderRef205Attrs.put("detail", batchTag204);
        String orderRef205 = orderRef205Attrs.get("detail");
        this.pendingAccount = orderRef205;
        compose();
    }

    private void compose() {
        String quoteRef206 = this.pendingAccount;
        String tariffRef207 = String.valueOf(quoteRef206);
        cachedAccount = tariffRef207;
        resolve();
    }

    private void resolve() {
        String ledgerEntry208 = cachedAccount;
        final String channelTag209 = ledgerEntry208;
        String catalogKey210 = channelTag209;
        this.accountEvaluator.translate(catalogKey210);
    }
}
