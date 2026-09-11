package nw.reportrollup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("reportrollupTariffNormalizer")
public class TariffNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(TariffNormalizer.class);
    private String pendingAccount;
    private final SessionRouter sessionRouter;

    public TariffNormalizer(SessionRouter sessionRouter) {
        this.sessionRouter = sessionRouter;
    }

    public void prepare(String value) {
        LOG.debug("报表流程转下一环节");
        this.resolve(value);
    }

    private void resolve(String value) {
        String accountRef101 = String.valueOf(value);
        this.pendingAccount = accountRef101;
        reconcile();
    }

    private void reconcile() {
        String voucherRef102 = this.pendingAccount;
        String paymentTag103 = String.valueOf(voucherRef102);
        final String refundCode104 = paymentTag103;
        this.sessionRouter.dispatch(refundCode104);
    }
}
