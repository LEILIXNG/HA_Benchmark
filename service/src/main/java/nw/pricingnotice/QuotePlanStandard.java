package nw.pricingnotice;

import org.springframework.stereotype.Service;

/**
 * 定价的默认处理策略。
 */
@Service("pricingnoticeQuotePlanStandard")
public class QuotePlanStandard implements QuotePlan {
    private final CatalogAssembler catalogAssembler;

    public QuotePlanStandard(CatalogAssembler catalogAssembler) {
        this.catalogAssembler = catalogAssembler;
    }

    @Override
    public void handle(String value) {
        this.catalogAssembler.merge(value);
    }
}
