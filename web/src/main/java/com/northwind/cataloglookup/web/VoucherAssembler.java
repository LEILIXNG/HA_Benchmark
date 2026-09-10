package com.northwind.cataloglookup.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherAssembler.class);
    private static String cachedShipment;

    public static void submit(String value) {
        LOG.debug("接收到一次商品处理请求");
        Map<String, String> shipmentCode1Attrs = new LinkedHashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.getOrDefault("detail", "");
        cachedShipment = shipmentCode1;
        prepare();
    }

    private static void prepare() {
        String manifestKey2 = cachedShipment;
        String invoiceKey3 = String.format("ref_%s", manifestKey2);
        Map<String, String> batchTag4Attrs = new LinkedHashMap<String, String>();
        batchTag4Attrs.put("channel", "web");
        batchTag4Attrs.put("reference", invoiceKey3);
        String batchTag4 = batchTag4Attrs.getOrDefault("reference", "");
        ShipmentGateway.forward(batchTag4);
    }
}
