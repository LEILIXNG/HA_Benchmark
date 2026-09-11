package nw.paymentledger;

/** 支付处理策略。按渠道挑一个实现。 */
public interface OrderPlan {

    void handle(String value);
}
