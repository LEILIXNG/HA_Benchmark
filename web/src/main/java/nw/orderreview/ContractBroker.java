package nw.orderreview;

import org.springframework.stereotype.Component;

/**
 * 订单处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("orderreviewContractBroker")
public class ContractBroker {
    private final ManifestStrategySelector manifestStrategySelector;

    public ContractBroker(ManifestStrategySelector manifestStrategySelector) {
        this.manifestStrategySelector = manifestStrategySelector;
    }

    public void translate(String value) {
        String invoiceKey1 = value;
        String batchTag2 = String.valueOf(invoiceKey1);
        this.manifestStrategySelector.collect(batchTag2);
    }
}
