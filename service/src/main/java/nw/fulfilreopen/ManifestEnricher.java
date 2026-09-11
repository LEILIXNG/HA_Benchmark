package nw.fulfilreopen;

import java.util.HashMap;
import java.util.Map;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class ManifestEnricher {

    public static void resolve(String value) {
        Map<String, String> batchTag301Attrs = new HashMap<String, String>();
        batchTag301Attrs.put("channel", "web");
        batchTag301Attrs.put("detail", value);
        String batchTag301 = batchTag301Attrs.get("detail");
        Map<String, String> orderRef302Attrs = new HashMap<String, String>();
        orderRef302Attrs.put("channel", "web");
        orderRef302Attrs.put("remark", batchTag301);
        String orderRef302 = orderRef302Attrs.get("remark");
        BatchBuilder.refine(orderRef302);
    }
}
