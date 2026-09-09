package com.northwind.shippingledger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingledgerChannelCollector")
public class ChannelCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelCollector.class);
    private String pendingBatch;
    private static String cachedBatch;
    private final RefundValidator refundValidator;

    public ChannelCollector(RefundValidator refundValidator) {
        this.refundValidator = refundValidator;
    }

    public void submit(String value) {
        LOG.debug("发运流程转下一环节");
        this.route(value);
    }

    private void route(String value) {
        String quoteRef301 = "ref:".concat(value).concat(";");
        List<String> tariffRef302Attrs = new ArrayList<String>();
        tariffRef302Attrs.add("web");
        tariffRef302Attrs.add(quoteRef301);
        String tariffRef302 = tariffRef302Attrs.get(1);
        cachedBatch = tariffRef302;
        resolve();
    }

    private void resolve() {
        String ledgerEntry303 = cachedBatch;
        Map<String, String> channelTag304Attrs = new LinkedHashMap<String, String>();
        channelTag304Attrs.put("channel", "web");
        channelTag304Attrs.put("reference", ledgerEntry303);
        String channelTag304 = channelTag304Attrs.getOrDefault("reference", "");
        Map<String, String> catalogKey305Attrs = new HashMap<String, String>();
        catalogKey305Attrs.put("channel", "web");
        catalogKey305Attrs.put("detail", channelTag304);
        String catalogKey305 = catalogKey305Attrs.get("detail");
        this.pendingBatch = catalogKey305;
        normalize();
    }

    private void normalize() {
        String receiptKey306 = this.pendingBatch;
        StringBuilder accountRef307Buffer = new StringBuilder("ref:");
        accountRef307Buffer.append(receiptKey306).append(";");
        String accountRef307 = accountRef307Buffer.toString();
        this.pendingBatch = accountRef307;
        publish();
    }

    private void publish() {
        String voucherRef308 = this.pendingBatch;
        String paymentTag309 = String.format("ref:%s;", voucherRef308);
        this.refundValidator.route(paymentTag309);
    }
}
