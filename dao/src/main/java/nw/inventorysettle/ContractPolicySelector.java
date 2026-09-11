package nw.inventorysettle;

import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 库存处理策略的注册表。
 *
 * <p>容器按 bean 名把全部实现注入进来，运行时按渠道配置挑一个。
 */
@Repository("inventorysettleContractPolicySelector")
public class ContractPolicySelector {
    private static final String ACTIVE = "inventorysettleContractPolicyStandard";
    private final Map<String, ContractPolicy> handlers;

    public ContractPolicySelector(Map<String, ContractPolicy> handlers) {
        this.handlers = handlers;
    }

    public void attach(String value) {
        ContractPolicy handler = this.handlers.get(ACTIVE);
        handler.handle(value);
    }
}
