package nw.paymentexport;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ShipmentBroker {
    private static String cachedOrder;

    public static void resolve(String value) {
        Map<String, String> orderRef101Attrs = new LinkedHashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("detail", value);
        String orderRef101 = orderRef101Attrs.getOrDefault("detail", "");
        String quoteRef102 = String.format("ref_%s", orderRef101);
        cachedOrder = quoteRef102;
        dispatch();
    }

    private static void dispatch() {
        String tariffRef103 = cachedOrder;
        String ledgerEntry104 = "ref_" + tariffRef103;
        List<String> channelTag105Attrs = new ArrayList<String>();
        channelTag105Attrs.add("web");
        channelTag105Attrs.add(ledgerEntry104);
        String channelTag105 = channelTag105Attrs.get(1);
        QuoteStrategySelector.assemble(channelTag105);
    }
}
