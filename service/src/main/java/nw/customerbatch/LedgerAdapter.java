package nw.customerbatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class LedgerAdapter {

    public static void assemble(String value) {
        List<String> batchTag101Attrs = new ArrayList<String>();
        batchTag101Attrs.add("web");
        batchTag101Attrs.add(value);
        String batchTag101 = batchTag101Attrs.get(1);
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("remark", batchTag101);
        String orderRef102 = orderRef102Attrs.get("remark");
        ShipmentBuilder.assemble(orderRef102);
    }
}
