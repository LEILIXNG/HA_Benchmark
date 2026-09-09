package com.northwind.accountadjust.web;

import com.northwind.accountadjust.service.PaymentRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账户主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("accountadjustShipmentBroker")
public class ShipmentBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentBroker.class);
    private final PaymentRegistry paymentRegistry;

    public ShipmentBroker(PaymentRegistry paymentRegistry) {
        this.paymentRegistry = paymentRegistry;
    }

    public void submit(String value) {
        LOG.debug("接收到一次账户处理请求");
        String accountRef101 = "ref:" + value + ";";
        Map<String, String> voucherRef102Attrs = new LinkedHashMap<String, String>();
        voucherRef102Attrs.put("channel", "web");
        voucherRef102Attrs.put("remark", accountRef101);
        String voucherRef102 = voucherRef102Attrs.getOrDefault("remark", "");
        this.paymentRegistry.enrich(voucherRef102);
    }
}
