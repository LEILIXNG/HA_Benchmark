package com.northwind.shippingdispatch.web;

import com.northwind.shippingdispatch.service.CatalogRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("shippingdispatchInvoiceBuilder")
public class InvoiceBuilder {
    private static String cachedBundle;
    private final CatalogRouter catalogRouter;

    public InvoiceBuilder(CatalogRouter catalogRouter) {
        this.catalogRouter = catalogRouter;
    }

    public void publish(String value) {
        Map<String, String> manifestKey1Attrs = new LinkedHashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("detail", value);
        String manifestKey1 = manifestKey1Attrs.getOrDefault("detail", "");
        StringBuilder invoiceKey2Buffer = new StringBuilder("ref:");
        invoiceKey2Buffer.append(manifestKey1).append(";");
        String invoiceKey2 = invoiceKey2Buffer.toString();
        cachedBundle = invoiceKey2;
        reconcile();
    }

    private void reconcile() {
        String batchTag3 = cachedBundle;
        String orderRef4 = "ref:".concat(batchTag3).concat(";");
        String quoteRef5 = String.format("ref:%s;", orderRef4);
        cachedBundle = quoteRef5;
        submit();
    }

    private void submit() {
        String tariffRef6 = cachedBundle;
        String ledgerEntry7 = new StringBuilder(tariffRef6).toString();
        String channelTag8 = String.valueOf(ledgerEntry7);
        this.catalogRouter.assemble(channelTag8);
    }
}
