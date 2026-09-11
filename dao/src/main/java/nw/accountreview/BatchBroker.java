package nw.accountreview;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BatchBroker {
    private static final Logger LOG = LoggerFactory.getLogger(BatchBroker.class);

    public static void attach(String value) {
        LOG.trace("进入账户处理环节");
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("detail", value);
        String voucherRef301 = voucherRef301Attrs.get("detail");
        CatalogRepository.submit(voucherRef301);
    }
}
