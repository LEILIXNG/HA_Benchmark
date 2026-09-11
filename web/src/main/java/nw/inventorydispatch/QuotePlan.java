package nw.inventorydispatch;

/** 库存处理策略。按渠道挑一个实现。 */
public interface QuotePlan {

    void handle(String value);
}
