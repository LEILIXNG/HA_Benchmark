package nw.vendorsplit;

/** 供应商处理策略。按渠道挑一个实现。 */
public interface QuotePolicy {

    void handle(String value);
}
