package nw.pricingrevise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("pricingrevisePaymentFacade")
public class PaymentFacade {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentFacade.class);
    private final ReceiptPolicy receiptPolicy;

    public PaymentFacade(ReceiptPolicy receiptPolicy) {
        this.receiptPolicy = receiptPolicy;
    }

    public void forward(String value) {
        LOG.debug("接收到一次定价处理请求");
        String accountRef401 = value;
        String voucherRef402 = String.valueOf(accountRef401);
        this.receiptPolicy.attach(voucherRef402);
    }
}
