package com.northwind.accountreview.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("accountreviewBundleService")
public class BundleService {
    private final SessionFacade sessionFacade;

    public BundleService(SessionFacade sessionFacade) {
        this.sessionFacade = sessionFacade;
    }

    public void translate(String value) {
        String voucherRef1 = value;
        Map<String, String> paymentTag2Attrs = new HashMap<String, String>();
        paymentTag2Attrs.put("channel", "web");
        paymentTag2Attrs.put("remark", voucherRef1);
        String paymentTag2 = paymentTag2Attrs.get("remark");
        this.sessionFacade.expand(paymentTag2);
    }
}
