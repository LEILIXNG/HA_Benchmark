package com.northwind.orderlookup.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("orderlookupAccountBuilder")
public class AccountBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(AccountBuilder.class);
    private final ReceiptExecutor receiptExecutor;

    public AccountBuilder(ReceiptExecutor receiptExecutor) {
        this.receiptExecutor = receiptExecutor;
    }

    public void merge(String value) {
        LOG.debug("开始整理订单字段");
        Map<String, String> batchTag401Attrs = new LinkedHashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("detail", value);
        String batchTag401 = batchTag401Attrs.getOrDefault("detail", "");
        Map<String, String> orderRef402Attrs = new HashMap<String, String>();
        orderRef402Attrs.put("channel", "web");
        orderRef402Attrs.put("remark", batchTag401);
        String orderRef402 = orderRef402Attrs.get("remark");
        this.receiptExecutor.assemble(orderRef402);
    }
}
