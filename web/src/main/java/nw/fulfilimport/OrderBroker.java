package nw.fulfilimport;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向履约场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilimportOrderBroker")
public class OrderBroker {
    private final BundleService bundleService;

    public OrderBroker(BundleService bundleService) {
        this.bundleService = bundleService;
    }

    public void compose(String value) {
        Map<String, String> batchTag1Attrs = new HashMap<String, String>();
        batchTag1Attrs.put("channel", "web");
        batchTag1Attrs.put("detail", value);
        String batchTag1 = batchTag1Attrs.get("detail");
        this.bundleService.submit(batchTag1);
    }
}
