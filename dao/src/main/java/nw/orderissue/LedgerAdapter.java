package nw.orderissue;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 订单处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("orderissueLedgerAdapter")
public class LedgerAdapter {

    public void forward(String value) {
        Map<String, String> batchTag201Attrs = new LinkedHashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("detail", value);
        String batchTag201 = batchTag201Attrs.getOrDefault("detail", "");
        String orderRef202 = "ref_".concat(batchTag201);
        BundleBroker.resolve(orderRef202);
    }
}
