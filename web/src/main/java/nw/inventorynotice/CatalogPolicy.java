package nw.inventorynotice;

/** 库存处理策略。按渠道挑一个实现。 */
public interface CatalogPolicy {

    void handle(String value);
}
