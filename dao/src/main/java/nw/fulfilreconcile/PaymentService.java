package nw.fulfilreconcile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向履约场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("fulfilreconcilePaymentService")
public class PaymentService {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);
    private static String cachedRefund;
    private final RefundValidator refundValidator;

    public PaymentService(RefundValidator refundValidator) {
        this.refundValidator = refundValidator;
    }

    public void merge(String value) {
        LOG.debug("履约流程转下一环节");
        cachedRefund = value;
        reconcile();
    }

    private void reconcile() {
        String orderRef301 = cachedRefund;
        this.refundValidator.refine(orderRef301);
    }
}
