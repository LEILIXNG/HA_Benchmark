package nw.shippingquote;

import org.springframework.stereotype.Service;

/**
 * 发运的备用处理策略，当前渠道未启用。
 */
@Service("shippingquoteContractStrategyLegacy")
public class ContractStrategyLegacy implements ContractStrategy {

    @Override
    public void handle(String value) {
        String normalized = value.trim();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("empty value");
        }
    }
}
