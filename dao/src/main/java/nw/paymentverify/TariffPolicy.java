package nw.paymentverify;

/** 支付处理策略。按渠道挑一个实现。 */
public interface TariffPolicy {

    void handle(String value);
}
