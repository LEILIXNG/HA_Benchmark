package nw.ordersync;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("ordersyncSessionAssembler")
public class SessionAssembler {

    public void register(String value) {
        Map<String, String> shipmentCode201Attrs = new LinkedHashMap<String, String>();
        shipmentCode201Attrs.put("channel", "web");
        shipmentCode201Attrs.put("detail", value);
        String shipmentCode201 = shipmentCode201Attrs.getOrDefault("detail", "");
        QuoteLoader.merge(shipmentCode201);
    }
}
