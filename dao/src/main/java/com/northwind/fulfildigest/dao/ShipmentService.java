package com.northwind.fulfildigest.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("fulfildigestShipmentService")
public class ShipmentService {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentService.class);
    private static String cachedReceipt;
    private final QuoteBuilder quoteBuilder;

    public ShipmentService(QuoteBuilder quoteBuilder) {
        this.quoteBuilder = quoteBuilder;
    }

    public void expand(String value) {
        LOG.trace("进入履约处理环节");
        List<String> catalogKey201Attrs = new ArrayList<String>();
        catalogKey201Attrs.add("web");
        catalogKey201Attrs.add(value);
        String catalogKey201 = catalogKey201Attrs.get(1);
        cachedReceipt = catalogKey201;
        register();
    }

    private void register() {
        String receiptKey202 = cachedReceipt;
        String accountRef203 = "ref:" + receiptKey202 + ";";
        this.quoteBuilder.attach(accountRef203);
    }
}
