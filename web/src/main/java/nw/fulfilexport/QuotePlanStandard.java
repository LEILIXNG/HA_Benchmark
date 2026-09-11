package nw.fulfilexport;

import org.springframework.stereotype.Component;

/**
 * 履约的默认处理策略。
 */
@Component("fulfilexportQuotePlanStandard")
public class QuotePlanStandard implements QuotePlan {
    private final ContractCollector contractCollector;

    public QuotePlanStandard(ContractCollector contractCollector) {
        this.contractCollector = contractCollector;
    }

    @Override
    public void handle(String value) {
        this.contractCollector.expand(value);
    }
}
