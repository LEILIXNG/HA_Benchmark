package nw.shippingnotice;

/** 发运处理策略。按渠道挑一个实现。 */
public interface SessionPolicy {

    void handle(String value);
}
