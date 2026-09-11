package nw.accountquote;

/** 账户处理策略。按渠道挑一个实现。 */
public interface CatalogStrategy {

    void handle(String value);
}
