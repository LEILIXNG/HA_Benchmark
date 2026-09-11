package nw.orderintake;

/** 订单处理策略。按渠道挑一个实现。 */
public interface ReceiptRule {

    void handle(String value);
}
