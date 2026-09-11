package nw.billingrenewal;

/** 账务处理策略。按渠道挑一个实现。 */
public interface LedgerStrategy {

    void handle(String value);
}
