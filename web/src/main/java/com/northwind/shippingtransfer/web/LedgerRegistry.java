package com.northwind.shippingtransfer.web;

import com.northwind.shippingtransfer.service.ManifestResolver;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("shippingtransferLedgerRegistry")
public class LedgerRegistry {
    private String pendingContract;
    private static String cachedContract;

    public void forward(String value) {
        this.route(value);
    }

    private void route(String value) {
        String accountRef201 = "ref:" + value + ";";
        String voucherRef202 = accountRef201;
        cachedContract = voucherRef202;
        enrich();
    }

    private void enrich() {
        String paymentTag203 = cachedContract;
        Map<String, String> refundCode204Attrs = new HashMap<String, String>();
        refundCode204Attrs.put("channel", "web");
        refundCode204Attrs.put("reference", paymentTag203);
        String refundCode204 = refundCode204Attrs.get("reference");
        String shipmentCode205 = String.format("ref:%s;", refundCode204);
        this.pendingContract = shipmentCode205;
        merge();
    }

    private void merge() {
        String manifestKey206 = this.pendingContract;
        Map<String, String> invoiceKey207Attrs = new HashMap<String, String>();
        invoiceKey207Attrs.put("channel", "web");
        invoiceKey207Attrs.put("note", manifestKey206);
        String invoiceKey207 = invoiceKey207Attrs.get("note");
        cachedContract = invoiceKey207;
        assemble();
    }

    private void assemble() {
        String batchTag208 = cachedContract;
        StringBuilder orderRef209Buffer = new StringBuilder("ref:");
        orderRef209Buffer.append(batchTag208).append(";");
        String orderRef209 = orderRef209Buffer.toString();
        ManifestResolver.enrich(orderRef209);
    }
}
