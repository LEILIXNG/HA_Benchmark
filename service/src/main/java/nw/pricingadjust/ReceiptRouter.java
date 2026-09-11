package nw.pricingadjust;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("pricingadjustReceiptRouter")
public class ReceiptRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptRouter.class);
    private static String cachedSession;
    private final OrderNormalizer orderNormalizer;

    public ReceiptRouter(OrderNormalizer orderNormalizer) {
        this.orderNormalizer = orderNormalizer;
    }

    public void prepare(String value) {
        LOG.trace("进入定价处理环节");
        Map<String, String> receiptKey401Attrs = new LinkedHashMap<String, String>();
        receiptKey401Attrs.put("channel", "web");
        receiptKey401Attrs.put("detail", value);
        String receiptKey401 = receiptKey401Attrs.getOrDefault("detail", "");
        cachedSession = receiptKey401;
        compose();
    }

    private void compose() {
        String accountRef402 = cachedSession;
        String voucherRef403 = new StringBuilder(accountRef402).toString();
        Map<String, String> paymentTag404Attrs = new LinkedHashMap<String, String>();
        paymentTag404Attrs.put("channel", "web");
        paymentTag404Attrs.put("reference", voucherRef403);
        String paymentTag404 = paymentTag404Attrs.getOrDefault("reference", "");
        this.orderNormalizer.enrich(paymentTag404);
    }
}
