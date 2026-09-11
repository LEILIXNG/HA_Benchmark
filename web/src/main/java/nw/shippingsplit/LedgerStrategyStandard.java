package nw.shippingsplit;

import org.springframework.stereotype.Component;

/**
 * 发运的默认处理策略。
 */
@Component("shippingsplitLedgerStrategyStandard")
public class LedgerStrategyStandard implements LedgerStrategy {
    private final ManifestRouter manifestRouter;

    public LedgerStrategyStandard(ManifestRouter manifestRouter) {
        this.manifestRouter = manifestRouter;
    }

    @Override
    public void handle(String value) {
        this.manifestRouter.enrich(value);
    }
}
