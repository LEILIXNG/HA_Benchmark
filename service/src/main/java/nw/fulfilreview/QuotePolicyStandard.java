package nw.fulfilreview;

/**
 * 履约的默认处理策略。
 */
public final class QuotePolicyStandard implements QuotePolicy {

    @Override
    public void handle(String value) {
        RefundAssembler.route(value);
    }
}
