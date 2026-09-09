package com.northwind.inventorylookup.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向库存场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ReceiptCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptCollector.class);
    private String pendingBatch;
    private static String cachedBatch;

    public static void collect(String value) {
        LOG.trace("进入库存处理环节");
        ReceiptCollector self = new ReceiptCollector();
        self.compose(value);
    }

    private void compose(String value) {
        final String accountRef201 = value;
        String voucherRef202 = String.format("ref:%s;", accountRef201);
        cachedBatch = voucherRef202;
        assemble();
    }

    private void assemble() {
        String paymentTag203 = cachedBatch;
        List<String> refundCode204Attrs = new ArrayList<String>();
        refundCode204Attrs.add("web");
        refundCode204Attrs.add(paymentTag203);
        String refundCode204 = refundCode204Attrs.get(1);
        this.pendingBatch = refundCode204;
        translate();
    }

    private void translate() {
        String shipmentCode205 = this.pendingBatch;
        String manifestKey206 = "ref:" + shipmentCode205 + ";";
        Map<String, String> invoiceKey207Attrs = new HashMap<String, String>();
        invoiceKey207Attrs.put("channel", "web");
        invoiceKey207Attrs.put("note", manifestKey206);
        String invoiceKey207 = invoiceKey207Attrs.get("note");
        BatchExecutor.assemble(invoiceKey207);
    }
}
