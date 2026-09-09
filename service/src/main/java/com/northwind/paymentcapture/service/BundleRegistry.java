package com.northwind.paymentcapture.service;

import com.northwind.paymentcapture.dao.VoucherRouter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向支付场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("paymentcaptureBundleRegistry")
public class BundleRegistry {
    private final VoucherRouter voucherRouter;

    public BundleRegistry(VoucherRouter voucherRouter) {
        this.voucherRouter = voucherRouter;
    }

    public void normalize(String value) {
        String orderRef201 = String.valueOf(value);
        Map<String, String> quoteRef202Attrs = new LinkedHashMap<String, String>();
        quoteRef202Attrs.put("channel", "web");
        quoteRef202Attrs.put("remark", orderRef201);
        String quoteRef202 = quoteRef202Attrs.getOrDefault("remark", "");
        this.voucherRouter.assemble(quoteRef202);
    }
}
