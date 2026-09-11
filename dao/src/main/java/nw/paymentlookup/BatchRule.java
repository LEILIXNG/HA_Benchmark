package nw.paymentlookup;

/** 支付处理策略。按渠道挑一个实现。 */
public interface BatchRule {

    void handle(String value);
}
