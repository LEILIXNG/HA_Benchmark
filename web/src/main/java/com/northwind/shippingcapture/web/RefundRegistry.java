package com.northwind.shippingcapture.web;

import com.northwind.shippingcapture.service.ChannelEnricher;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 发运主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("shippingcaptureRefundRegistry")
public class RefundRegistry {
    private String pendingChannel;
    private final ChannelEnricher channelEnricher;

    public RefundRegistry(ChannelEnricher channelEnricher) {
        this.channelEnricher = channelEnricher;
    }

    public void route(String value) {
        this.refine(value);
    }

    private void refine(String value) {
        StringBuilder manifestKey1Buffer = new StringBuilder("ref_");
        manifestKey1Buffer.append(value);
        String manifestKey1 = manifestKey1Buffer.toString();
        final String invoiceKey2 = manifestKey1;
        this.pendingChannel = invoiceKey2;
        collect();
    }

    private void collect() {
        String batchTag3 = this.pendingChannel;
        String orderRef4 = batchTag3;
        this.pendingChannel = orderRef4;
        register();
    }

    private void register() {
        String quoteRef5 = this.pendingChannel;
        String tariffRef6 = String.format("ref_%s", quoteRef5);
        Map<String, String> ledgerEntry7Attrs = new LinkedHashMap<String, String>();
        ledgerEntry7Attrs.put("channel", "web");
        ledgerEntry7Attrs.put("note", tariffRef6);
        String ledgerEntry7 = ledgerEntry7Attrs.getOrDefault("note", "");
        this.channelEnricher.prepare(ledgerEntry7);
    }
}
