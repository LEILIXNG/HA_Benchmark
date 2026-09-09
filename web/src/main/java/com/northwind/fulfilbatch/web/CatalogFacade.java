package com.northwind.fulfilbatch.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilbatchCatalogFacade")
public class CatalogFacade {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogFacade.class);
    private String pendingTariff;
    private final TariffFetcher tariffFetcher;

    public CatalogFacade(TariffFetcher tariffFetcher) {
        this.tariffFetcher = tariffFetcher;
    }

    public void resolve(String value) {
        LOG.debug("接收到一次履约处理请求");
        this.assemble(value);
    }

    private void assemble(String value) {
        StringBuilder voucherRef101Buffer = new StringBuilder("ref:");
        voucherRef101Buffer.append(value).append(";");
        String voucherRef101 = voucherRef101Buffer.toString();
        this.pendingTariff = voucherRef101;
        translate();
    }

    private void translate() {
        String paymentTag102 = this.pendingTariff;
        String refundCode103 = String.valueOf(paymentTag102);
        final String shipmentCode104 = refundCode103;
        this.tariffFetcher.normalize(shipmentCode104);
    }
}
