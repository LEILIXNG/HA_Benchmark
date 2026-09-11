package nw.fulfilledger;

import org.springframework.stereotype.Component;

/**
 * 履约的默认处理策略。
 */
@Component("fulfilledgerTariffPolicyStandard")
public class TariffPolicyStandard implements TariffPolicy {
    private final RefundFacade refundFacade;

    public TariffPolicyStandard(RefundFacade refundFacade) {
        this.refundFacade = refundFacade;
    }

    @Override
    public void handle(String value) {
        this.refundFacade.assemble(value);
    }
}
