package com.northwind.shippingledger.web;

import com.northwind.shippingledger.service.ChannelCollector;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("shippingledgerChannelBuilder")
public class ChannelBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelBuilder.class);
    private String pendingBatch;
    private final ChannelCollector channelCollector;

    public ChannelBuilder(ChannelCollector channelCollector) {
        this.channelCollector = channelCollector;
    }

    public void stage(String value) {
        LOG.debug("发运流程转下一环节");
        this.register(value);
    }

    private void register(String value) {
        String receiptKey201 = "ref_" + value;
        this.pendingBatch = receiptKey201;
        refine();
    }

    private void refine() {
        String accountRef202 = this.pendingBatch;
        String voucherRef203 = "ref_" + accountRef202;
        String paymentTag204 = "ref_".concat(voucherRef203);
        this.pendingBatch = paymentTag204;
        merge();
    }

    private void merge() {
        String refundCode205 = this.pendingBatch;
        String shipmentCode206 = "ref_".concat(refundCode205);
        this.pendingBatch = shipmentCode206;
        dispatch();
    }

    private void dispatch() {
        String manifestKey207 = this.pendingBatch;
        Map<String, String> invoiceKey208Attrs = new HashMap<String, String>();
        invoiceKey208Attrs.put("channel", "web");
        invoiceKey208Attrs.put("reference", manifestKey207);
        String invoiceKey208 = invoiceKey208Attrs.get("reference");
        String batchTag209 = String.valueOf(invoiceKey208);
        this.channelCollector.submit(batchTag209);
    }
}
