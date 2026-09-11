package nw.paymentcapture;

/** 支付处理策略。按渠道挑一个实现。 */
public interface PaymentStrategy {

    void handle(String value);
}
