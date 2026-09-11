package nw.fulfilmanifest;

/** 履约处理策略。按渠道挑一个实现。 */
public interface PaymentPolicy {

    void handle(String value);
}
