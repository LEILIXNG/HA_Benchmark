package nw.paymentledger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ContractBuilder {

    public static void normalize(String value) {
        Map<String, String> channelTag201Attrs = new HashMap<String, String>();
        channelTag201Attrs.put("channel", "web");
        channelTag201Attrs.put("detail", value);
        String channelTag201 = channelTag201Attrs.get("detail");
        List<String> catalogKey202Attrs = new ArrayList<String>();
        catalogKey202Attrs.add("web");
        catalogKey202Attrs.add(channelTag201);
        String catalogKey202 = catalogKey202Attrs.get(1);
        LedgerPlanSelector.forward(catalogKey202);
    }
}
