package nw.inventorydispatch;

/** 库存处理策略。按渠道挑一个实现。 */
public interface CatalogRule {

    void handle(String value);
}
