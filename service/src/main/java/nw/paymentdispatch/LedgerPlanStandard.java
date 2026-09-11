package nw.paymentdispatch;

import org.springframework.stereotype.Service;

/**
 * 支付的默认处理策略。
 */
@Service("paymentdispatchLedgerPlanStandard")
public class LedgerPlanStandard implements LedgerPlan {
    private final PaymentFacade paymentFacade;

    public LedgerPlanStandard(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @Override
    public void handle(String value) {
        this.paymentFacade.dispatch(value);
    }
}
