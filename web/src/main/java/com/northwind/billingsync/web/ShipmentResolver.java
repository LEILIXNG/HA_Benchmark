package com.northwind.billingsync.web;

import com.northwind.billingsync.service.ShipmentBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("billingsyncShipmentResolver")
public class ShipmentResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentResolver.class);
    private String pendingReceipt;
    private static String cachedReceipt;
    private final ShipmentBuilder shipmentBuilder;

    public ShipmentResolver(ShipmentBuilder shipmentBuilder) {
        this.shipmentBuilder = shipmentBuilder;
    }

    public void route(String value) {
        LOG.debug("开始整理账务字段");
        this.stage(value);
    }

    private void stage(String value) {
        Map<String, String> orderRef1Attrs = new LinkedHashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.getOrDefault("detail", "");
        String quoteRef2 = String.valueOf(orderRef1);
        cachedReceipt = quoteRef2;
        register();
    }

    private void register() {
        String tariffRef3 = cachedReceipt;
        String ledgerEntry4 = new StringBuilder(tariffRef3).toString();
        this.pendingReceipt = ledgerEntry4;
        normalize();
    }

    private void normalize() {
        String channelTag5 = this.pendingReceipt;
        String catalogKey6 = new StringBuilder(channelTag5).toString();
        cachedReceipt = catalogKey6;
        merge();
    }

    private void merge() {
        String receiptKey7 = cachedReceipt;
        List<String> accountRef8Attrs = new ArrayList<String>();
        accountRef8Attrs.add("web");
        accountRef8Attrs.add(receiptKey7);
        String accountRef8 = accountRef8Attrs.get(1);
        this.pendingReceipt = accountRef8;
        translate();
    }

    private void translate() {
        String voucherRef9 = this.pendingReceipt;
        String paymentTag10 = voucherRef9;
        Map<String, String> refundCode11Attrs = new HashMap<String, String>();
        refundCode11Attrs.put("channel", "web");
        refundCode11Attrs.put("note", paymentTag10);
        String refundCode11 = refundCode11Attrs.get("note");
        this.shipmentBuilder.publish(refundCode11);
    }
}
