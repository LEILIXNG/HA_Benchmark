package com.northwind.vendorrefund.service;

import com.northwind.vendorrefund.dao.PaymentCoordinator;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("vendorrefundChannelResolver")
public class ChannelResolver {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelResolver.class);
    private String pendingShipment;
    private final PaymentCoordinator paymentCoordinator;

    public ChannelResolver(PaymentCoordinator paymentCoordinator) {
        this.paymentCoordinator = paymentCoordinator;
    }

    public void expand(String value) {
        LOG.trace("进入供应商处理环节");
        this.refine(value);
    }

    private void refine(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("detail", value);
        String shipmentCode101 = shipmentCode101Attrs.get("detail");
        this.pendingShipment = shipmentCode101;
        dispatch();
    }

    private void dispatch() {
        String manifestKey102 = this.pendingShipment;
        Map<String, String> invoiceKey103Attrs = new HashMap<String, String>();
        invoiceKey103Attrs.put("channel", "web");
        invoiceKey103Attrs.put("note", manifestKey102);
        String invoiceKey103 = invoiceKey103Attrs.get("note");
        final String batchTag104 = invoiceKey103;
        this.paymentCoordinator.route(batchTag104);
    }
}
