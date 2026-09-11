package nw.accountimport;

/** 账户处理策略。按渠道挑一个实现。 */
public interface BatchStrategy {

    void handle(String value);
}
