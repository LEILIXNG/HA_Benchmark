package nw.vendornotice;

import org.springframework.stereotype.Service;

/**
 * 供应商的默认处理策略。
 */
@Service("vendornoticeBundleRuleStandard")
public class BundleRuleStandard implements BundleRule {
    private final AccountBroker accountBroker;

    public BundleRuleStandard(AccountBroker accountBroker) {
        this.accountBroker = accountBroker;
    }

    @Override
    public void handle(String value) {
        this.accountBroker.resolve(value);
    }
}
