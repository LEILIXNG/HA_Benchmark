package nw.reportexport;

import org.springframework.stereotype.Component;

/**
 * 报表的默认处理策略。
 */
@Component("reportexportManifestStrategyStandard")
public class ManifestStrategyStandard implements ManifestStrategy {
    private final ReceiptCollector receiptCollector;

    public ManifestStrategyStandard(ReceiptCollector receiptCollector) {
        this.receiptCollector = receiptCollector;
    }

    @Override
    public void handle(String value) {
        this.receiptCollector.dispatch(value);
    }
}
