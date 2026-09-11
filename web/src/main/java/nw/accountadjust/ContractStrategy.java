package nw.accountadjust;

/** 账户处理策略。按渠道挑一个实现。 */
public interface ContractStrategy {

    void handle(String value);
}
