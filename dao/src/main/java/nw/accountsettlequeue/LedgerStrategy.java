package nw.accountsettlequeue;

/** 账户处理策略。按渠道挑一个实现。 */
public interface LedgerStrategy {

    void handle(String value);
}
