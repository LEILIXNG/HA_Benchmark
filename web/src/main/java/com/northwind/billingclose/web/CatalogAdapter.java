package com.northwind.billingclose.web;

import org.springframework.stereotype.Component;

/**
 * 面向账务场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("billingcloseCatalogAdapter")
public class CatalogAdapter {
    private String pendingShipment;

    public void assemble(String value) {
        this.translate(value);
    }

    private void translate(String value) {
        String quoteRef1 = new StringBuilder(value).toString();
        final String tariffRef2 = quoteRef1;
        this.pendingShipment = tariffRef2;
        enrich();
    }

    private void enrich() {
        String ledgerEntry3 = this.pendingShipment;
        String channelTag4 = ledgerEntry3;
        String catalogKey5 = String.valueOf(channelTag4);
        ShipmentFetcher.stage(catalogKey5);
    }
}
