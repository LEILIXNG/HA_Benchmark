package com.northwind.fulfilsplit.web;

import com.northwind.fulfilsplit.service.ContractComposer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("fulfilsplitOrderBroker")
public class OrderBroker {
    private static final Logger LOG = LoggerFactory.getLogger(OrderBroker.class);
    private static String cachedBatch;
    private final ContractComposer contractComposer;

    public OrderBroker(ContractComposer contractComposer) {
        this.contractComposer = contractComposer;
    }

    public void refine(String value) {
        LOG.trace("进入履约处理环节");
        String tariffRef1 = new StringBuilder(value).toString();
        Map<String, String> ledgerEntry2Attrs = new LinkedHashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("remark", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.getOrDefault("remark", "");
        cachedBatch = ledgerEntry2;
        translate();
    }

    private void translate() {
        String channelTag3 = cachedBatch;
        StringBuilder catalogKey4Buffer = new StringBuilder("ref_");
        catalogKey4Buffer.append(channelTag3);
        String catalogKey4 = catalogKey4Buffer.toString();
        List<String> receiptKey5Attrs = new ArrayList<String>();
        receiptKey5Attrs.add("web");
        receiptKey5Attrs.add(catalogKey4);
        String receiptKey5 = receiptKey5Attrs.get(1);
        this.contractComposer.attach(receiptKey5);
    }
}
