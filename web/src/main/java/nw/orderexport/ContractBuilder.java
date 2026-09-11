package nw.orderexport;

import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("orderexportContractBuilder")
public class ContractBuilder {
    private final AccountNormalizer accountNormalizer;

    public ContractBuilder(AccountNormalizer accountNormalizer) {
        this.accountNormalizer = accountNormalizer;
    }

    public void submit(String value) {
        this.accountNormalizer.register(value);
    }
}
