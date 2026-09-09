package com.northwind.reportreopen.web;

import com.northwind.reportreopen.service.BundleBuilder;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("reportreopenPaymentAdapter")
public class PaymentAdapter {
    private final BundleBuilder bundleBuilder;

    public PaymentAdapter(BundleBuilder bundleBuilder) {
        this.bundleBuilder = bundleBuilder;
    }

    public void compose(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("detail", value);
        String voucherRef101 = voucherRef101Attrs.get("detail");
        StringBuilder paymentTag102Buffer = new StringBuilder("ref:");
        paymentTag102Buffer.append(voucherRef101).append(";");
        String paymentTag102 = paymentTag102Buffer.toString();
        this.bundleBuilder.submit(paymentTag102);
    }
}
