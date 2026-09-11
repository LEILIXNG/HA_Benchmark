package nw.inventorysettle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("inventorysettleContractBroker")
public class ContractBroker {
    private static final Logger LOG = LoggerFactory.getLogger(ContractBroker.class);
    private final ContractPolicySelector contractPolicySelector;

    public ContractBroker(ContractPolicySelector contractPolicySelector) {
        this.contractPolicySelector = contractPolicySelector;
    }

    public void refine(String value) {
        LOG.debug("库存流程转下一环节");
        String tariffRef301 = value;
        this.contractPolicySelector.attach(tariffRef301);
    }
}
