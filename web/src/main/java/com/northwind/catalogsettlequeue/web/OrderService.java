package com.northwind.catalogsettlequeue.web;

import com.northwind.catalogsettlequeue.service.ShipmentRouter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogsettlequeueOrderService")
public class OrderService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
    private static String cachedRefund;
    private final ShipmentRouter shipmentRouter;

    public OrderService(ShipmentRouter shipmentRouter) {
        this.shipmentRouter = shipmentRouter;
    }

    public void route(String value) {
        LOG.debug("开始整理商品字段");
        String paymentTag1 = String.format("ref:%s;", value);
        cachedRefund = paymentTag1;
        compose();
    }

    private void compose() {
        String refundCode2 = cachedRefund;
        List<String> shipmentCode3Attrs = new ArrayList<String>();
        shipmentCode3Attrs.add("web");
        shipmentCode3Attrs.add(refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.get(1);
        this.shipmentRouter.assemble(shipmentCode3);
    }
}
