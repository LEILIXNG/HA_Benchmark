package com.northwind.shippingcapture.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("shippingcaptureChannelEnricher")
public class ChannelEnricher {
    private String pendingChannel;
    private static String cachedChannel;

    public void prepare(String value) {
        this.route(value);
    }

    private void route(String value) {
        String accountRef101 = "ref:" + value + ";";
        this.pendingChannel = accountRef101;
        compose();
    }

    private void compose() {
        String voucherRef102 = this.pendingChannel;
        String paymentTag103 = voucherRef102;
        cachedChannel = paymentTag103;
        resolve();
    }

    private void resolve() {
        String refundCode104 = cachedChannel;
        String shipmentCode105 = String.format("ref:%s;", refundCode104);
        Map<String, String> manifestKey106Attrs = new HashMap<String, String>();
        manifestKey106Attrs.put("channel", "web");
        manifestKey106Attrs.put("remark", shipmentCode105);
        String manifestKey106 = manifestKey106Attrs.get("remark");
        TariffComposer.resolve(manifestKey106);
    }
}
