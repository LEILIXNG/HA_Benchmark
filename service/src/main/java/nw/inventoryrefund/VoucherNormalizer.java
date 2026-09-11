package nw.inventoryrefund;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 库存受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("inventoryrefundVoucherNormalizer")
public class VoucherNormalizer {
    private final BatchGuard batchGuard;

    public VoucherNormalizer(BatchGuard batchGuard) {
        this.batchGuard = batchGuard;
    }

    public void publish(String value) {
        Map<String, String> paymentTag101Attrs = new LinkedHashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("detail", value);
        String paymentTag101 = paymentTag101Attrs.getOrDefault("detail", "");
        this.batchGuard.attach(paymentTag101);
    }
}
