package nw.pricingexport;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingexportLedgerStrategyStandard")
public class LedgerStrategyStandard implements LedgerStrategy {
    private final BundleFacade bundleFacade;

    public LedgerStrategyStandard(BundleFacade bundleFacade) {
        this.bundleFacade = bundleFacade;
    }

    @Override
    public void handle(String value) {
        this.bundleFacade.translate(value);
    }
}
