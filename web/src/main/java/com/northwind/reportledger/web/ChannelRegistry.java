package com.northwind.reportledger.web;

import com.northwind.reportledger.service.ChannelCoordinator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 报表处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("reportledgerChannelRegistry")
public class ChannelRegistry {
    private static String cachedVoucher;

    public void prepare(String value) {
        StringBuilder accountRef1Buffer = new StringBuilder("ref_");
        accountRef1Buffer.append(value);
        String accountRef1 = accountRef1Buffer.toString();
        cachedVoucher = accountRef1;
        normalize();
    }

    private void normalize() {
        String voucherRef2 = cachedVoucher;
        Map<String, String> paymentTag3Attrs = new LinkedHashMap<String, String>();
        paymentTag3Attrs.put("channel", "web");
        paymentTag3Attrs.put("note", voucherRef2);
        String paymentTag3 = paymentTag3Attrs.getOrDefault("note", "");
        Map<String, String> refundCode4Attrs = new HashMap<String, String>();
        refundCode4Attrs.put("channel", "web");
        refundCode4Attrs.put("reference", paymentTag3);
        String refundCode4 = refundCode4Attrs.get("reference");
        ChannelCoordinator.compose(refundCode4);
    }
}
