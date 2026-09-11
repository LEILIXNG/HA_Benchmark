package nw.shippingsplit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("shippingsplitReceiptNormalizer")
public class ReceiptNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptNormalizer.class);
    private final PaymentBroker paymentBroker;

    public ReceiptNormalizer(PaymentBroker paymentBroker) {
        this.paymentBroker = paymentBroker;
    }

    public void attach(String value) {
        LOG.debug("接收到一次发运处理请求");
        final String orderRef301 = value;
        String quoteRef302 = new StringBuilder(orderRef301).toString();
        this.paymentBroker.attach(quoteRef302);
    }
}
