package com.northwind.catalogquote.service;

import org.springframework.stereotype.Service;

/**
 * 商品明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("catalogquoteCatalogAssembler")
public class CatalogAssembler {
    private String pendingTariff;

    public void compose(String value) {
        this.publish(value);
    }

    private void publish(String value) {
        String manifestKey201 = new StringBuilder(value).toString();
        String invoiceKey202 = "ref_".concat(manifestKey201);
        this.pendingTariff = invoiceKey202;
        merge();
    }

    private void merge() {
        String batchTag203 = this.pendingTariff;
        StringBuilder orderRef204Buffer = new StringBuilder("ref_");
        orderRef204Buffer.append(batchTag203);
        String orderRef204 = orderRef204Buffer.toString();
        TariffLoader.enrich(orderRef204);
    }
}
