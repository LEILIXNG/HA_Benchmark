package nw.catalogdispatch;

import org.springframework.stereotype.Component;

/**
 * 商品的默认处理策略。
 */
@Component("catalogdispatchBatchStrategyStandard")
public class BatchStrategyStandard implements BatchStrategy {
    private final BundleTranslator bundleTranslator;

    public BatchStrategyStandard(BundleTranslator bundleTranslator) {
        this.bundleTranslator = bundleTranslator;
    }

    @Override
    public void handle(String value) {
        this.bundleTranslator.merge(value);
    }
}
