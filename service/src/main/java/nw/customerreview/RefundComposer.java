package nw.customerreview;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向客户场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("customerreviewRefundComposer")
public class RefundComposer {
    private static final Logger LOG = LoggerFactory.getLogger(RefundComposer.class);
    private final PaymentBuilder paymentBuilder;

    public RefundComposer(PaymentBuilder paymentBuilder) {
        this.paymentBuilder = paymentBuilder;
    }

    public void collect(String value) {
        LOG.debug("开始整理客户字段");
        Map<String, String> batchTag401Attrs = new HashMap<String, String>();
        batchTag401Attrs.put("channel", "web");
        batchTag401Attrs.put("detail", value);
        String batchTag401 = batchTag401Attrs.get("detail");
        this.paymentBuilder.compose(batchTag401);
    }
}
