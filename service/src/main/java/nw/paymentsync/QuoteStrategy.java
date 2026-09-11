package nw.paymentsync;

/** 支付处理策略。按渠道挑一个实现。 */
public interface QuoteStrategy {

    void handle(String value);
}
