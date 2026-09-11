package nw.orderrelease;

import org.springframework.stereotype.Repository;

/**
 * 订单的默认处理策略。
 */
@Repository("orderreleaseTariffRuleStandard")
public class TariffRuleStandard implements TariffRule {
    private final AccountAdapter accountAdapter;

    public TariffRuleStandard(AccountAdapter accountAdapter) {
        this.accountAdapter = accountAdapter;
    }

    @Override
    public void handle(String value) {
        this.accountAdapter.dispatch(value);
    }
}
