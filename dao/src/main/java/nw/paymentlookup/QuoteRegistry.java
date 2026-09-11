package nw.paymentlookup;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向支付场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class QuoteRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteRegistry.class);
    private static String cachedSession;

    public static void refine(String value) {
        LOG.debug("接收到一次支付处理请求");
        String batchTag301 = String.format("ref_%s", value);
        String orderRef302 = batchTag301;
        cachedSession = orderRef302;
        stage();
    }

    private static void stage() {
        String quoteRef303 = cachedSession;
        Map<String, String> tariffRef304Attrs = new HashMap<String, String>();
        tariffRef304Attrs.put("channel", "web");
        tariffRef304Attrs.put("reference", quoteRef303);
        String tariffRef304 = tariffRef304Attrs.get("reference");
        SessionGateway.attach(tariffRef304);
    }
}
