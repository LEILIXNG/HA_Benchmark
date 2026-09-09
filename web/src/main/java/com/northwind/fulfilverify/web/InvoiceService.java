package com.northwind.fulfilverify.web;

import com.northwind.fulfilverify.service.CatalogFacade;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("fulfilverifyInvoiceService")
public class InvoiceService {
    private final CatalogFacade catalogFacade;

    public InvoiceService(CatalogFacade catalogFacade) {
        this.catalogFacade = catalogFacade;
    }

    public void normalize(String value) {
        String batchTag101 = String.valueOf(value);
        this.catalogFacade.reconcile(batchTag101);
    }
}
