package nw.paymentposting;

/** 支付处理策略。按渠道挑一个实现。 */
public interface OrderStrategy {

    void handle(String value);
}
