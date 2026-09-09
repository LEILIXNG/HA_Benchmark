package com.northwind.inventorycapture.web;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class InvoiceResolver {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceResolver.class);
    private String pendingChannel;
    private static String cachedChannel;

    public static void forward(String value) {
        LOG.debug("开始整理库存字段");
        InvoiceResolver self = new InvoiceResolver();
        self.normalize(value);
    }

    private void normalize(String value) {
        StringBuilder manifestKey1Buffer = new StringBuilder("ref:");
        manifestKey1Buffer.append(value).append(";");
        String manifestKey1 = manifestKey1Buffer.toString();
        Map<String, String> invoiceKey2Attrs = new HashMap<String, String>();
        invoiceKey2Attrs.put("channel", "web");
        invoiceKey2Attrs.put("remark", manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get("remark");
        cachedChannel = invoiceKey2;
        collect();
    }

    private void collect() {
        String batchTag3 = cachedChannel;
        String orderRef4 = new StringBuilder(batchTag3).toString();
        String quoteRef5 = "ref:".concat(orderRef4).concat(";");
        this.pendingChannel = quoteRef5;
        translate();
    }

    private void translate() {
        String tariffRef6 = this.pendingChannel;
        String ledgerEntry7 = "ref:".concat(tariffRef6).concat(";");
        ChannelExecutor.resolve(ledgerEntry7);
    }
}
