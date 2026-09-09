package com.northwind.ordersubmit.service;

import com.northwind.ordersubmit.dao.ShipmentService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("ordersubmitReceiptResolver")
public class ReceiptResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptResolver.class);
    private final ShipmentService shipmentService;

    public ReceiptResolver(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    public void register(String value) {
        LOG.debug("订单流程转下一环节");
        List<String> orderRef101Attrs = new ArrayList<String>();
        orderRef101Attrs.add("web");
        orderRef101Attrs.add(value);
        String orderRef101 = orderRef101Attrs.get(1);
        String quoteRef102 = String.format("ref:%s;", orderRef101);
        this.shipmentService.translate(quoteRef102);
    }
}
