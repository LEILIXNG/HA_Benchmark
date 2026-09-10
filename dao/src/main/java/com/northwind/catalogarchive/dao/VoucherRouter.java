package com.northwind.catalogarchive.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class VoucherRouter {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherRouter.class);
    private String pendingShipment;
    private static String cachedShipment;

    public static void collect(String value) {
        LOG.trace("进入商品处理环节");
        VoucherRouter self = new VoucherRouter();
        self.compose(value);
    }

    private void compose(String value) {
        Map<String, String> invoiceKey301Attrs = new LinkedHashMap<String, String>();
        invoiceKey301Attrs.put("channel", "web");
        invoiceKey301Attrs.put("detail", value);
        String invoiceKey301 = invoiceKey301Attrs.getOrDefault("detail", "");
        final String batchTag302 = invoiceKey301;
        this.pendingShipment = batchTag302;
        expand();
    }

    private void expand() {
        String orderRef303 = this.pendingShipment;
        String quoteRef304 = orderRef303;
        cachedShipment = quoteRef304;
        normalize();
    }

    private void normalize() {
        String tariffRef305 = cachedShipment;
        StringBuilder ledgerEntry306Buffer = new StringBuilder("ref_");
        ledgerEntry306Buffer.append(tariffRef305);
        String ledgerEntry306 = ledgerEntry306Buffer.toString();
        this.pendingShipment = ledgerEntry306;
        prepare();
    }

    private void prepare() {
        String channelTag307 = this.pendingShipment;
        List<String> catalogKey308Attrs = new ArrayList<String>();
        catalogKey308Attrs.add("web");
        catalogKey308Attrs.add(channelTag307);
        String catalogKey308 = catalogKey308Attrs.get(1);
        ShipmentExecutor.translate(catalogKey308);
    }
}
