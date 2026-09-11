package nw.fulfilrollup;

import org.springframework.stereotype.Component;

/**
 * 履约的默认处理策略。
 */
@Component("fulfilrollupBatchRuleStandard")
public class BatchRuleStandard implements BatchRule {
    private final ManifestTranslator manifestTranslator;

    public BatchRuleStandard(ManifestTranslator manifestTranslator) {
        this.manifestTranslator = manifestTranslator;
    }

    @Override
    public void handle(String value) {
        this.manifestTranslator.refine(value);
    }
}
