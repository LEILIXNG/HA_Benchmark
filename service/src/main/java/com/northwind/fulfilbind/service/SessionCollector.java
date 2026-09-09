package com.northwind.fulfilbind.service;

import com.northwind.fulfilbind.dao.ShipmentFacade;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("fulfilbindSessionCollector")
public class SessionCollector {
    private static final Logger LOG = LoggerFactory.getLogger(SessionCollector.class);
    private final ShipmentFacade shipmentFacade;

    public SessionCollector(ShipmentFacade shipmentFacade) {
        this.shipmentFacade = shipmentFacade;
    }

    public void translate(String value) {
        LOG.trace("进入履约处理环节");
        Map<String, String> refundCode101Attrs = new LinkedHashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.getOrDefault("detail", "");
        this.shipmentFacade.forward(refundCode101);
    }
}
