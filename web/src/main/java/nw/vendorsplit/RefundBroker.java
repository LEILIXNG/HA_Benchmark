package nw.vendorsplit;

import org.springframework.stereotype.Component;

/**
 * 供应商处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorsplitRefundBroker")
public class RefundBroker {
    private final BatchEnricher batchEnricher;

    public RefundBroker(BatchEnricher batchEnricher) {
        this.batchEnricher = batchEnricher;
    }

    public void reconcile(String value) {
        String ledgerEntry101 = String.valueOf(value);
        this.batchEnricher.normalize(ledgerEntry101);
    }
}
