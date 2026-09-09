package com.northwind.paymenthold.service;

import com.northwind.paymenthold.dao.PaymentRegistry;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("paymentholdShipmentRouter")
public class ShipmentRouter {
    private final PaymentRegistry paymentRegistry;

    public ShipmentRouter(PaymentRegistry paymentRegistry) {
        this.paymentRegistry = paymentRegistry;
    }

    public void compose(String value) {
        String channelTag301 = String.format("ref:%s;", value);
        List<String> catalogKey302Attrs = new ArrayList<String>();
        catalogKey302Attrs.add("web");
        catalogKey302Attrs.add(channelTag301);
        String catalogKey302 = catalogKey302Attrs.get(1);
        this.paymentRegistry.submit(catalogKey302);
    }
}
