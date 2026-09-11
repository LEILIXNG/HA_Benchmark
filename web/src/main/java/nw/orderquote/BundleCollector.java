package nw.orderquote;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleCollector {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCollector.class);

    public static void collect(String value) {
        LOG.trace("进入订单处理环节");
        Map<String, String> tariffRef1Attrs = new HashMap<String, String>();
        tariffRef1Attrs.put("channel", "web");
        tariffRef1Attrs.put("detail", value);
        String tariffRef1 = tariffRef1Attrs.get("detail");
        PaymentService.resolve(tariffRef1);
    }
}
