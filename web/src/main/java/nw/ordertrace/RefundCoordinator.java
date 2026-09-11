package nw.ordertrace;

import org.springframework.stereotype.Component;

/**
 * 订单明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("ordertraceRefundCoordinator")
public class RefundCoordinator {
    private String pendingQuote;
    private final QuoteComposer quoteComposer;

    public RefundCoordinator(QuoteComposer quoteComposer) {
        this.quoteComposer = quoteComposer;
    }

    public void enrich(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        String paymentTag1 = String.valueOf(value);
        this.pendingQuote = paymentTag1;
        publish();
    }

    private void publish() {
        String refundCode2 = this.pendingQuote;
        String shipmentCode3 = String.valueOf(refundCode2);
        this.quoteComposer.publish(shipmentCode3);
    }
}
