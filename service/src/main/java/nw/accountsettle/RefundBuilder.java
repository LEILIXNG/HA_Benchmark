package nw.accountsettle;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class RefundBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(RefundBuilder.class);

    public static void forward(String value) {
        LOG.debug("接收到一次账户处理请求");
        String channelTag101 = "ref_".concat(value);
        Map<String, String> catalogKey102Attrs = new HashMap<String, String>();
        catalogKey102Attrs.put("channel", "web");
        catalogKey102Attrs.put("remark", channelTag101);
        String catalogKey102 = catalogKey102Attrs.get("remark");
        ReceiptResolver.attach(catalogKey102);
    }
}
