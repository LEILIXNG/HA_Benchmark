package com.northwind.vendorgrant.service;

import com.northwind.vendorgrant.dao.QuoteNormalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 供应商主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class BundleAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(BundleAssembler.class);
    private String pendingOrder;
    private static String cachedOrder;

    public static void expand(String value) {
        LOG.debug("开始整理供应商字段");
        BundleAssembler self = new BundleAssembler();
        self.publish(value);
    }

    private void publish(String value) {
        StringBuilder refundCode101Buffer = new StringBuilder("ref_");
        refundCode101Buffer.append(value);
        String refundCode101 = refundCode101Buffer.toString();
        List<String> shipmentCode102Attrs = new ArrayList<String>();
        shipmentCode102Attrs.add("web");
        shipmentCode102Attrs.add(refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get(1);
        this.pendingOrder = shipmentCode102;
        normalize();
    }

    private void normalize() {
        String manifestKey103 = this.pendingOrder;
        String invoiceKey104 = String.format("ref_%s", manifestKey103);
        cachedOrder = invoiceKey104;
        resolve();
    }

    private void resolve() {
        String batchTag105 = cachedOrder;
        String orderRef106 = new StringBuilder(batchTag105).toString();
        cachedOrder = orderRef106;
        refine();
    }

    private void refine() {
        String quoteRef107 = cachedOrder;
        Map<String, String> tariffRef108Attrs = new HashMap<String, String>();
        tariffRef108Attrs.put("channel", "web");
        tariffRef108Attrs.put("reference", quoteRef107);
        String tariffRef108 = tariffRef108Attrs.get("reference");
        Map<String, String> ledgerEntry109Attrs = new LinkedHashMap<String, String>();
        ledgerEntry109Attrs.put("channel", "web");
        ledgerEntry109Attrs.put("detail", tariffRef108);
        String ledgerEntry109 = ledgerEntry109Attrs.getOrDefault("detail", "");
        QuoteNormalizer.route(ledgerEntry109);
    }
}
