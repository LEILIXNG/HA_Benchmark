package nw.orderarchive;

import org.springframework.stereotype.Service;

/**
 * 订单的默认处理策略。
 */
@Service("orderarchiveContractStrategyStandard")
public class ContractStrategyStandard implements ContractStrategy {
    private final VoucherCollector voucherCollector;

    public ContractStrategyStandard(VoucherCollector voucherCollector) {
        this.voucherCollector = voucherCollector;
    }

    @Override
    public void handle(String value) {
        this.voucherCollector.attach(value);
    }
}
