package com.northwind.paymentintake.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 支付处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("paymentintakeBatchFacade")
public class BatchFacade {
    private final VoucherFetcher voucherFetcher;

    public BatchFacade(VoucherFetcher voucherFetcher) {
        this.voucherFetcher = voucherFetcher;
    }

    public void register(String value) {
        String quoteRef301 = String.format("ref_%s", value);
        Map<String, String> tariffRef302Attrs = new HashMap<String, String>();
        tariffRef302Attrs.put("channel", "web");
        tariffRef302Attrs.put("remark", quoteRef301);
        String tariffRef302 = tariffRef302Attrs.get("remark");
        this.voucherFetcher.enrich(tariffRef302);
    }
}
