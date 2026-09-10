package com.northwind.fulfilrenewal.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilrenewalContractEnricher")
public class ContractEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ContractEnricher.class);
    private String pendingContract;
    private static String cachedContract;
    private final ReceiptStrategySelector receiptStrategySelector;

    public ContractEnricher(ReceiptStrategySelector receiptStrategySelector) {
        this.receiptStrategySelector = receiptStrategySelector;
    }

    public void attach(String value) {
        LOG.trace("进入履约处理环节");
        this.forward(value);
    }

    private void forward(String value) {
        Map<String, String> refundCode1Attrs = new LinkedHashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("detail", value);
        String refundCode1 = refundCode1Attrs.getOrDefault("detail", "");
        List<String> shipmentCode2Attrs = new ArrayList<String>();
        shipmentCode2Attrs.add("web");
        shipmentCode2Attrs.add(refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get(1);
        this.pendingContract = shipmentCode2;
        normalize();
    }

    private void normalize() {
        String manifestKey3 = this.pendingContract;
        String invoiceKey4 = "ref_".concat(manifestKey3);
        String batchTag5 = invoiceKey4;
        cachedContract = batchTag5;
        publish();
    }

    private void publish() {
        String orderRef6 = cachedContract;
        String quoteRef7 = orderRef6;
        cachedContract = quoteRef7;
        dispatch();
    }

    private void dispatch() {
        String tariffRef8 = cachedContract;
        String ledgerEntry9 = new StringBuilder(tariffRef8).toString();
        Map<String, String> channelTag10Attrs = new HashMap<String, String>();
        channelTag10Attrs.put("channel", "web");
        channelTag10Attrs.put("remark", ledgerEntry9);
        String channelTag10 = channelTag10Attrs.get("remark");
        this.receiptStrategySelector.translate(channelTag10);
    }
}
