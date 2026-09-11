package nw.paymentsettlequeue;

/** 支付处理策略。按渠道挑一个实现。 */
public interface ContractStrategy {

    void handle(String value);
}
