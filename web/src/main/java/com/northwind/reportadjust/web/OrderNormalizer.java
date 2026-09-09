package com.northwind.reportadjust.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向报表场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportadjustOrderNormalizer")
public class OrderNormalizer {
    private String pendingContract;

    public void compose(String value) {
        this.refine(value);
    }

    private void refine(String value) {
        StringBuilder refundCode101Buffer = new StringBuilder("ref:");
        refundCode101Buffer.append(value).append(";");
        String refundCode101 = refundCode101Buffer.toString();
        this.pendingContract = refundCode101;
        resolve();
    }

    private void resolve() {
        String shipmentCode102 = this.pendingContract;
        StringBuilder manifestKey103Buffer = new StringBuilder("ref:");
        manifestKey103Buffer.append(shipmentCode102).append(";");
        String manifestKey103 = manifestKey103Buffer.toString();
        String invoiceKey104 = String.format("ref:%s;", manifestKey103);
        this.pendingContract = invoiceKey104;
        translate();
    }

    private void translate() {
        String batchTag105 = this.pendingContract;
        String orderRef106 = String.format("ref:%s;", batchTag105);
        Map<String, String> quoteRef107Attrs = new HashMap<String, String>();
        quoteRef107Attrs.put("channel", "web");
        quoteRef107Attrs.put("note", orderRef106);
        String quoteRef107 = quoteRef107Attrs.get("note");
        this.pendingContract = quoteRef107;
        attach();
    }

    private void attach() {
        String tariffRef108 = this.pendingContract;
        String ledgerEntry109 = tariffRef108;
        String channelTag110 = String.format("ref:%s;", ledgerEntry109);
        SessionEnricher.dispatch(channelTag110);
    }
}
