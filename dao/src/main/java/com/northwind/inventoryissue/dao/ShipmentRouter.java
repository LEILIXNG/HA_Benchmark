package com.northwind.inventoryissue.dao;

import org.springframework.stereotype.Repository;

/**
 * 库存处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("inventoryissueShipmentRouter")
public class ShipmentRouter {
    private String pendingManifest;
    private final CatalogPlanSelector catalogPlanSelector;

    public ShipmentRouter(CatalogPlanSelector catalogPlanSelector) {
        this.catalogPlanSelector = catalogPlanSelector;
    }

    public void compose(String value) {
        this.forward(value);
    }

    private void forward(String value) {
        String ledgerEntry201 = "ref_".concat(value);
        String channelTag202 = String.format("ref_%s", ledgerEntry201);
        this.pendingManifest = channelTag202;
        route();
    }

    private void route() {
        String catalogKey203 = this.pendingManifest;
        String receiptKey204 = "ref_" + catalogKey203;
        StringBuilder accountRef205Buffer = new StringBuilder("ref_");
        accountRef205Buffer.append(receiptKey204);
        String accountRef205 = accountRef205Buffer.toString();
        this.catalogPlanSelector.stage(accountRef205);
    }
}
