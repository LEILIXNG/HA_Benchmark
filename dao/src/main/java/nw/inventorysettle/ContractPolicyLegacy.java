package nw.inventorysettle;

import org.springframework.stereotype.Repository;

/**
 * 库存的备用处理策略，当前渠道未启用。
 */
@Repository("inventorysettleContractPolicyLegacy")
public class ContractPolicyLegacy implements ContractPolicy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
