package com.northwind.accountmerge.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("accountmergeSessionBuilder")
public class SessionBuilder {
    private static String cachedShipment;
    private final ShipmentRepository shipmentRepository;

    public SessionBuilder(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public void expand(String value) {
        String orderRef101 = "ref:".concat(value).concat(";");
        String quoteRef102 = String.format("ref:%s;", orderRef101);
        cachedShipment = quoteRef102;
        reconcile();
    }

    private void reconcile() {
        String tariffRef103 = cachedShipment;
        String ledgerEntry104 = tariffRef103;
        Map<String, String> channelTag105Attrs = new HashMap<String, String>();
        channelTag105Attrs.put("channel", "web");
        channelTag105Attrs.put("detail", ledgerEntry104);
        String channelTag105 = channelTag105Attrs.get("detail");
        this.shipmentRepository.stage(channelTag105);
    }
}
