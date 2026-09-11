package nw.accountsettlequeue;

import org.springframework.stereotype.Repository;

/**
 * 账户的默认处理策略。
 */
@Repository("accountsettlequeueLedgerStrategyStandard")
public class LedgerStrategyStandard implements LedgerStrategy {
    private final BundleCoordinator bundleCoordinator;

    public LedgerStrategyStandard(BundleCoordinator bundleCoordinator) {
        this.bundleCoordinator = bundleCoordinator;
    }

    @Override
    public void handle(String value) {
        this.bundleCoordinator.publish(value);
    }
}
