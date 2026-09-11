package nw.pricingsettlequeue;

/** 定价处理策略。按渠道挑一个实现。 */
public interface CatalogRule {

    void handle(String value);
}
