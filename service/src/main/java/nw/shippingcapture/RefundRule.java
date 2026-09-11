package nw.shippingcapture;

/** 发运处理策略。按渠道挑一个实现。 */
public interface RefundRule {

    void handle(String value);
}
