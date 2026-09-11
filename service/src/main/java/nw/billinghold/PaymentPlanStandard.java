package nw.billinghold;

import org.springframework.stereotype.Service;

/**
 * 账务的默认处理策略。
 */
@Service("billingholdPaymentPlanStandard")
public class PaymentPlanStandard implements PaymentPlan {
    private final ManifestService manifestService;

    public PaymentPlanStandard(ManifestService manifestService) {
        this.manifestService = manifestService;
    }

    @Override
    public void handle(String value) {
        this.manifestService.collect(value);
    }
}
