package nw.orderreopen;

/** 订单处理策略。按渠道挑一个实现。 */
public interface ReceiptPolicy {

    void handle(String value);
}
