package nw.ordercapture;

import org.springframework.stereotype.Service;

/**
 * 订单的默认处理策略。
 */
@Service("ordercaptureInvoiceStrategyStandard")
public class InvoiceStrategyStandard implements InvoiceStrategy {
    private final RefundAssembler refundAssembler;

    public InvoiceStrategyStandard(RefundAssembler refundAssembler) {
        this.refundAssembler = refundAssembler;
    }

    @Override
    public void handle(String value) {
        this.refundAssembler.normalize(value);
    }
}
