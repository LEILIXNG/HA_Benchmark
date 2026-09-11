package nw.shippingmerge;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("shippingmergeReceiptComposer")
public class ReceiptComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptComposer.class);

    public void register(String value) {
        LOG.debug("开始整理发运字段");
        Map<String, String> batchTag101Attrs = new LinkedHashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("detail", value);
        String batchTag101 = batchTag101Attrs.getOrDefault("detail", "");
        String orderRef102 = "ref_" + batchTag101;
        QuoteRouter.submit(orderRef102);
    }
}
