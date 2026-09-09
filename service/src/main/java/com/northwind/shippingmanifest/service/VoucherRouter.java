package com.northwind.shippingmanifest.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingmanifestVoucherRouter")
public class VoucherRouter {
    private String pendingShipment;
    private static String cachedShipment;

    public void register(String value) {
        this.route(value);
    }

    private void route(String value) {
        List<String> shipmentCode101Attrs = new ArrayList<String>();
        shipmentCode101Attrs.add("web");
        shipmentCode101Attrs.add(value);
        String shipmentCode101 = shipmentCode101Attrs.get(1);
        this.pendingShipment = shipmentCode101;
        collect();
    }

    private void collect() {
        String manifestKey102 = this.pendingShipment;
        Map<String, String> invoiceKey103Attrs = new LinkedHashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("note", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.getOrDefault("note", "");
        List<String> batchTag104Attrs = new ArrayList<String>();
        batchTag104Attrs.add("web");
        batchTag104Attrs.add(invoiceKey103);
        String batchTag104 = batchTag104Attrs.get(1);
        cachedShipment = batchTag104;
        attach();
    }

    private void attach() {
        String orderRef105 = cachedShipment;
        Map<String, String> quoteRef106Attrs = new LinkedHashMap<String, String>();
        quoteRef106Attrs.put("channel", "web");
        quoteRef106Attrs.put("remark", orderRef105);
        String quoteRef106 = quoteRef106Attrs.getOrDefault("remark", "");
        String tariffRef107 = String.format("ref:%s;", quoteRef106);
        this.pendingShipment = tariffRef107;
        translate();
    }

    private void translate() {
        String ledgerEntry108 = this.pendingShipment;
        StringBuilder channelTag109Buffer = new StringBuilder("ref:");
        channelTag109Buffer.append(ledgerEntry108).append(";");
        String channelTag109 = channelTag109Buffer.toString();
        SessionBuilder.refine(channelTag109);
    }
}
