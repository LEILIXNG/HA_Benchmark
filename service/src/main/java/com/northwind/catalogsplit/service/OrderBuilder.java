package com.northwind.catalogsplit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("catalogsplitOrderBuilder")
public class OrderBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(OrderBuilder.class);
    private static String cachedAccount;
    private final ContractPlanSelector contractPlanSelector;

    public OrderBuilder(ContractPlanSelector contractPlanSelector) {
        this.contractPlanSelector = contractPlanSelector;
    }

    public void dispatch(String value) {
        LOG.debug("接收到一次商品处理请求");
        String quoteRef101 = String.format("ref_%s", value);
        cachedAccount = quoteRef101;
        merge();
    }

    private void merge() {
        String tariffRef102 = cachedAccount;
        String ledgerEntry103 = String.format("ref_%s", tariffRef102);
        StringBuilder channelTag104Buffer = new StringBuilder("ref_");
        channelTag104Buffer.append(ledgerEntry103);
        String channelTag104 = channelTag104Buffer.toString();
        this.contractPlanSelector.prepare(channelTag104);
    }
}
