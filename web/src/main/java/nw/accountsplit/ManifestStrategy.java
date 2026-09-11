package nw.accountsplit;

/** 账户处理策略。按渠道挑一个实现。 */
public interface ManifestStrategy {

    void handle(String value);
}
