package nw.pricingnotice;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingnoticeAccountRuleStandard")
public class AccountRuleStandard implements AccountRule {
    private final AccountRouter accountRouter;

    public AccountRuleStandard(AccountRouter accountRouter) {
        this.accountRouter = accountRouter;
    }

    @Override
    public void handle(String value) {
        this.accountRouter.compose(value);
    }
}
