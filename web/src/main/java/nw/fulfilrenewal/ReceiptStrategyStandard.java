package nw.fulfilrenewal;

import org.springframework.stereotype.Component;

/**
 * 履约的默认处理策略。
 */
@Component("fulfilrenewalReceiptStrategyStandard")
public class ReceiptStrategyStandard implements ReceiptStrategy {
    private final ContractService contractService;

    public ReceiptStrategyStandard(ContractService contractService) {
        this.contractService = contractService;
    }

    @Override
    public void handle(String value) {
        this.contractService.forward(value);
    }
}
