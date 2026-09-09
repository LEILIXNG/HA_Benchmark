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
        String quoteRef1 = "ref:".concat(value).concat(";");
        final String tariffRef2 = quoteRef1;
        this.pendingShipment = tariffRef2;
        enrich();
    }

    private void enrich() {
        String ledgerEntry3 = this.pendingShipment;
        String channelTag4 = "ref:" + ledgerEntry3 + ";";
        StringBuilder catalogKey5Buffer = new StringBuilder("ref:");
        catalogKey5Buffer.append(channelTag4).append(";");
        String catalogKey5 = catalogKey5Buffer.toString();
        ShipmentFetcher.stage(catalogKey5);
    }
}
