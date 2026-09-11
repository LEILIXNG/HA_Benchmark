package nw.inventoryapprove;

import org.springframework.stereotype.Component;

/**
 * 库存的默认处理策略。
 */
@Component("inventoryapproveBundleRuleStandard")
public class BundleRuleStandard implements BundleRule {
    private final AccountComposer accountComposer;

    public BundleRuleStandard(AccountComposer accountComposer) {
        this.accountComposer = accountComposer;
    }

    @Override
    public void handle(String value) {
        this.accountComposer.dispatch(value);
    }
}
