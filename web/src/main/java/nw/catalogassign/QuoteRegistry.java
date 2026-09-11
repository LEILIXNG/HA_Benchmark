package nw.catalogassign;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class QuoteRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteRegistry.class);

    public static void reconcile(String value) {
        LOG.debug("接收到一次商品处理请求");
        String tariffRef1 = String.valueOf(value);
        Map<String, String> ledgerEntry2Attrs = new HashMap<String, String>();
        ledgerEntry2Attrs.put("channel", "web");
        ledgerEntry2Attrs.put("remark", tariffRef1);
        String ledgerEntry2 = ledgerEntry2Attrs.get("remark");
        QuoteRouter.normalize(ledgerEntry2);
    }
}
