package com.northwind.paymentsubmit.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("paymentsubmitBatchEnricher")
public class BatchEnricher {
    private final LedgerService ledgerService;

    public BatchEnricher(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }

    public void stage(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("detail", value);
        String voucherRef201 = voucherRef201Attrs.get("detail");
        String paymentTag202 = new StringBuilder(voucherRef201).toString();
        this.ledgerService.refine(paymentTag202);
    }
}
