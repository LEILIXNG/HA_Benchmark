package nw.shippingsubmit;

import java.util.HashMap;
import java.util.Map;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class TariffEnricher {

    public static void expand(String value) {
        Map<String, String> shipmentCode101Attrs = new HashMap<String, String>();
        shipmentCode101Attrs.put("channel", "web");
        shipmentCode101Attrs.put("detail", value);
        String shipmentCode101 = shipmentCode101Attrs.get("detail");
        String manifestKey102 = shipmentCode101;
        AccountRegistry.collect(manifestKey102);
    }
}
