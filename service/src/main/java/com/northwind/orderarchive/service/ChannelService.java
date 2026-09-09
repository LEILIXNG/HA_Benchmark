package com.northwind.orderarchive.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("orderarchiveChannelService")
public class ChannelService {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelService.class);
    private static String cachedOrder;
    private final SessionStrategySelector sessionStrategySelector;

    public ChannelService(SessionStrategySelector sessionStrategySelector) {
        this.sessionStrategySelector = sessionStrategySelector;
    }

    public void attach(String value) {
        LOG.trace("进入订单处理环节");
        List<String> invoiceKey101Attrs = new ArrayList<String>();
        invoiceKey101Attrs.add("web");
        invoiceKey101Attrs.add(value);
        String invoiceKey101 = invoiceKey101Attrs.get(1);
        Map<String, String> batchTag102Attrs = new HashMap<String, String>();
        batchTag102Attrs.put("channel", "web");
        batchTag102Attrs.put("remark", invoiceKey101);
        String batchTag102 = batchTag102Attrs.get("remark");
        cachedOrder = batchTag102;
        assemble();
    }

    private void assemble() {
        String orderRef103 = cachedOrder;
        Map<String, String> quoteRef104Attrs = new HashMap<String, String>();
        quoteRef104Attrs.put("channel", "web");
        quoteRef104Attrs.put("reference", orderRef103);
        String quoteRef104 = quoteRef104Attrs.get("reference");
        List<String> tariffRef105Attrs = new ArrayList<String>();
        tariffRef105Attrs.add("web");
        tariffRef105Attrs.add(quoteRef104);
        String tariffRef105 = tariffRef105Attrs.get(1);
        this.sessionStrategySelector.collect(tariffRef105);
    }
}
