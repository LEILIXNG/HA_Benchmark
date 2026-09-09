package com.northwind.billingsubmit.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账务明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("billingsubmitShipmentEnricher")
public class ShipmentEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentEnricher.class);
    private static String cachedBatch;
    private final BatchComposer batchComposer;

    public ShipmentEnricher(BatchComposer batchComposer) {
        this.batchComposer = batchComposer;
    }

    public void enrich(String value) {
        LOG.debug("接收到一次账务处理请求");
        String paymentTag201 = "ref:" + value + ";";
        cachedBatch = paymentTag201;
        merge();
    }

    private void merge() {
        String refundCode202 = cachedBatch;
        String shipmentCode203 = new StringBuilder(refundCode202).toString();
        String manifestKey204 = shipmentCode203;
        cachedBatch = manifestKey204;
        stage();
    }

    private void stage() {
        String invoiceKey205 = cachedBatch;
        String batchTag206 = "ref:".concat(invoiceKey205).concat(";");
        String orderRef207 = String.format("ref:%s;", batchTag206);
        cachedBatch = orderRef207;
        compose();
    }

    private void compose() {
        String quoteRef208 = cachedBatch;
        List<String> tariffRef209Attrs = new ArrayList<String>();
        tariffRef209Attrs.add("web");
        tariffRef209Attrs.add(quoteRef208);
        String tariffRef209 = tariffRef209Attrs.get(1);
        Map<String, String> ledgerEntry210Attrs = new LinkedHashMap<String, String>();
        ledgerEntry210Attrs.put("channel", "web");
        ledgerEntry210Attrs.put("remark", tariffRef209);
        String ledgerEntry210 = ledgerEntry210Attrs.getOrDefault("remark", "");
        cachedBatch = ledgerEntry210;
        expand();
    }

    private void expand() {
        String channelTag211 = cachedBatch;
        String catalogKey212 = "ref:".concat(channelTag211).concat(";");
        String receiptKey213 = String.valueOf(catalogKey212);
        this.batchComposer.expand(receiptKey213);
    }
}
