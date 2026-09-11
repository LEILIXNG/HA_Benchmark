package nw.inventoryrenewal;

import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventoryrenewalQuoteAssembler")
public class QuoteAssembler {
    private final RefundCoordinator refundCoordinator;

    public QuoteAssembler(RefundCoordinator refundCoordinator) {
        this.refundCoordinator = refundCoordinator;
    }

    public void prepare(String value) {
        final String accountRef1 = value;
        this.refundCoordinator.forward(accountRef1);
    }
}
