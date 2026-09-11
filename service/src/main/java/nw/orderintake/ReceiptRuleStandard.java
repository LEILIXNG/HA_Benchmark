package nw.orderintake;

import org.springframework.stereotype.Service;

/**
 * 订单的默认处理策略。
 */
@Service("orderintakeReceiptRuleStandard")
public class ReceiptRuleStandard implements ReceiptRule {
    private final TariffCollector tariffCollector;

    public ReceiptRuleStandard(TariffCollector tariffCollector) {
        this.tariffCollector = tariffCollector;
    }

    @Override
    public void handle(String value) {
        this.tariffCollector.attach(value);
    }
}
