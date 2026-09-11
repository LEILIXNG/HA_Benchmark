package nw.orderlookup;

/** 订单处理策略。按渠道挑一个实现。 */
public interface PaymentRule {

    void handle(String value);
}
