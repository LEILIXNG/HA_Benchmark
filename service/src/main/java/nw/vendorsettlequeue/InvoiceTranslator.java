package nw.vendorsettlequeue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class InvoiceTranslator {

    public static void route(String value) {
        Map<String, String> batchTag201Attrs = new LinkedHashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("detail", value);
        String batchTag201 = batchTag201Attrs.getOrDefault("detail", "");
        OrderGateway.register(batchTag201);
    }
}
