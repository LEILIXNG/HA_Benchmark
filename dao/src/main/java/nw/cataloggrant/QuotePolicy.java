package nw.cataloggrant;

/** 商品处理策略。按渠道挑一个实现。 */
public interface QuotePolicy {

    void handle(String value);
}
