package com.northwind.reportrefund.web;

import com.northwind.reportrefund.service.CatalogRouter;
import org.springframework.stereotype.Component;

/**
 * 报表受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("reportrefundInvoiceRouter")
public class InvoiceRouter {

    public void enrich(String value) {
        String quoteRef1 = "ref:".concat(value).concat(";");
        String tariffRef2 = String.format("ref:%s;", quoteRef1);
        CatalogRouter.stage(tariffRef2);
    }
}
