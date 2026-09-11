package nw.inventorybatch;

/** 库存处理策略。按渠道挑一个实现。 */
public interface CatalogStrategy {

    void handle(String value);
}
