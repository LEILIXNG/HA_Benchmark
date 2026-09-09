package com.northwind.fulfildigest.web;

import com.northwind.fulfildigest.service.ContractService;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfildigestReceiptBroker")
public class ReceiptBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptBroker.class);
    private final ContractService contractService;

    public ReceiptBroker(ContractService contractService) {
        this.contractService = contractService;
    }

    public void prepare(String value) {
        LOG.trace("进入履约处理环节");
        Map<String, String> orderRef1Attrs = new HashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.get("detail");
        String quoteRef2 = orderRef1;
        this.contractService.forward(quoteRef2);
    }
}
