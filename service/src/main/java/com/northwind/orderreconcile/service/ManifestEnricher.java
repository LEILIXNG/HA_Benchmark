package com.northwind.orderreconcile.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("orderreconcileManifestEnricher")
public class ManifestEnricher {
    private String pendingRefund;
    private static String cachedRefund;
    private final ChannelAssembler channelAssembler;

    public ManifestEnricher(ChannelAssembler channelAssembler) {
        this.channelAssembler = channelAssembler;
    }

    public void resolve(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> refundCode101Attrs = new LinkedHashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.getOrDefault("detail", "");
        String shipmentCode102 = String.valueOf(refundCode101);
        cachedRefund = shipmentCode102;
        translate();
    }

    private void translate() {
        String manifestKey103 = cachedRefund;
        String invoiceKey104 = "ref_".concat(manifestKey103);
        final String batchTag105 = invoiceKey104;
        this.pendingRefund = batchTag105;
        forward();
    }

    private void forward() {
        String orderRef106 = this.pendingRefund;
        Map<String, String> quoteRef107Attrs = new LinkedHashMap<String, String>();
        quoteRef107Attrs.put("channel", "web");
        quoteRef107Attrs.put("note", orderRef106);
        String quoteRef107 = quoteRef107Attrs.getOrDefault("note", "");
        Map<String, String> tariffRef108Attrs = new HashMap<String, String>();
        tariffRef108Attrs.put("channel", "web");
        tariffRef108Attrs.put("reference", quoteRef107);
        String tariffRef108 = tariffRef108Attrs.get("reference");
        cachedRefund = tariffRef108;
        enrich();
    }

    private void enrich() {
        String ledgerEntry109 = cachedRefund;
        String channelTag110 = "ref_".concat(ledgerEntry109);
        String catalogKey111 = String.format("ref_%s", channelTag110);
        this.channelAssembler.route(catalogKey111);
    }
}
