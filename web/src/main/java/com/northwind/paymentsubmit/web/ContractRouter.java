package com.northwind.paymentsubmit.web;

import com.northwind.paymentsubmit.service.BatchEnricher2;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 支付处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("paymentsubmitContractRouter")
public class ContractRouter {
    private final BatchEnricher2 batchEnricher2;

    public ContractRouter(BatchEnricher2 batchEnricher2) {
        this.batchEnricher2 = batchEnricher2;
    }

    public void enrich(String value) {
        Map<String, String> ledgerEntry1Attrs = new LinkedHashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("detail", value);
        String ledgerEntry1 = ledgerEntry1Attrs.getOrDefault("detail", "");
        String channelTag2 = "ref:" + ledgerEntry1 + ";";
        this.batchEnricher2.reconcile(channelTag2);
    }
}
