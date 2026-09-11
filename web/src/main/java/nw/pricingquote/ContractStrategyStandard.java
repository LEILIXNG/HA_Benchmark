package nw.pricingquote;

import org.springframework.stereotype.Component;

/**
 * 定价的默认处理策略。
 */
@Component("pricingquoteContractStrategyStandard")
public class ContractStrategyStandard implements ContractStrategy {
    private final CatalogNormalizer catalogNormalizer;

    public ContractStrategyStandard(CatalogNormalizer catalogNormalizer) {
        this.catalogNormalizer = catalogNormalizer;
    }

    @Override
    public void handle(String value) {
        this.catalogNormalizer.route(value);
    }
}
