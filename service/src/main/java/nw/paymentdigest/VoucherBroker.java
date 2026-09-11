package nw.paymentdigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("paymentdigestVoucherBroker")
public class VoucherBroker {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherBroker.class);
    private final PaymentService paymentService;

    public VoucherBroker(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void register(String value) {
        LOG.debug("接收到一次支付处理请求");
        StringBuilder quoteRef101Buffer = new StringBuilder("ref_");
        quoteRef101Buffer.append(value);
        String quoteRef101 = quoteRef101Buffer.toString();
        this.paymentService.publish(quoteRef101);
    }
}
