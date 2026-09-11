package nw.customerbind;

/** 客户处理策略。按渠道挑一个实现。 */
public interface LedgerPolicy {

    void handle(String value);
}
