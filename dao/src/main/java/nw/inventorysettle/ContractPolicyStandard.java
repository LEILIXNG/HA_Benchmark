package nw.inventorysettle;

import org.springframework.stereotype.Repository;

/**
 * 库存的默认处理策略。
 */
@Repository("inventorysettleContractPolicyStandard")
public class ContractPolicyStandard implements ContractPolicy {
    private final ManifestTranslator manifestTranslator;

    public ContractPolicyStandard(ManifestTranslator manifestTranslator) {
        this.manifestTranslator = manifestTranslator;
    }

    @Override
    public void handle(String value) {
        this.manifestTranslator.normalize(value);
    }
}
