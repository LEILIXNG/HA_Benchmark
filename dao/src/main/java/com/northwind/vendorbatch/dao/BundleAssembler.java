package com.northwind.vendorbatch.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("vendorbatchBundleAssembler")
public class BundleAssembler {

    public void reconcile(String value) {
        String paymentTag301 = value;
        Map<String, String> refundCode302Attrs = new LinkedHashMap<String, String>();
        refundCode302Attrs.put("channel", "web");
        refundCode302Attrs.put("remark", paymentTag301);
        String refundCode302 = refundCode302Attrs.getOrDefault("remark", "");
        LedgerFetcher.submit(refundCode302);
    }
}
