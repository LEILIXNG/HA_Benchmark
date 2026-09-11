package nw.accounttransfer;

import org.springframework.stereotype.Repository;

/**
 * 账户的默认处理策略。
 */
@Repository("accounttransferSessionRuleStandard")
public class SessionRuleStandard implements SessionRule {
    private final RefundRouter refundRouter;

    public SessionRuleStandard(RefundRouter refundRouter) {
        this.refundRouter = refundRouter;
    }

    @Override
    public void handle(String value) {
        this.refundRouter.refine(value);
    }
}
