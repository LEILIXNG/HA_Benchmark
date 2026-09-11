package nw.vendornotice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("vendornoticeAccountAdapter")
public class AccountAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(AccountAdapter.class);
    private String pendingBatch;
    private final BatchEvaluator batchEvaluator;

    public AccountAdapter(BatchEvaluator batchEvaluator) {
        this.batchEvaluator = batchEvaluator;
    }

    public void refine(String value) {
        LOG.debug("接收到一次供应商处理请求");
        this.compose(value);
    }

    private void compose(String value) {
        final String voucherRef501 = value;
        Map<String, String> paymentTag502Attrs = new LinkedHashMap<String, String>();
        paymentTag502Attrs.put("channel", "web");
        paymentTag502Attrs.put("remark", voucherRef501);
        String paymentTag502 = paymentTag502Attrs.getOrDefault("remark", "");
        this.pendingBatch = paymentTag502;
        attach();
    }

    private void attach() {
        String refundCode503 = this.pendingBatch;
        Map<String, String> shipmentCode504Attrs = new HashMap<String, String>();
        shipmentCode504Attrs.put("channel", "web");
        shipmentCode504Attrs.put("reference", refundCode503);
        String shipmentCode504 = shipmentCode504Attrs.get("reference");
        this.batchEvaluator.resolve(shipmentCode504);
    }
}
