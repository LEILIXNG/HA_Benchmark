package nw.accounttransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 账户处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("accounttransferRefundComposer")
public class RefundComposer {
    private static final Logger LOG = LoggerFactory.getLogger(RefundComposer.class);
    private final PaymentTranslator paymentTranslator;

    public RefundComposer(PaymentTranslator paymentTranslator) {
        this.paymentTranslator = paymentTranslator;
    }

    public void assemble(String value) {
        LOG.debug("账户流程转下一环节");
        final String catalogKey201 = value;
        this.paymentTranslator.refine(catalogKey201);
    }
}
