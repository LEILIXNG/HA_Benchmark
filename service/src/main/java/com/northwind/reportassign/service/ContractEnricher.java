package com.northwind.reportassign.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("reportassignContractEnricher")
public class ContractEnricher {
    private final VoucherEvaluator voucherEvaluator;

    public ContractEnricher(VoucherEvaluator voucherEvaluator) {
        this.voucherEvaluator = voucherEvaluator;
    }

    public void expand(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("detail", value);
        String voucherRef201 = voucherRef201Attrs.get("detail");
        String paymentTag202 = voucherRef201;
        this.voucherEvaluator.translate(paymentTag202);
    }
}
