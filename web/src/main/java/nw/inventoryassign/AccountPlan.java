package nw.inventoryassign;

/** 库存处理策略。按渠道挑一个实现。 */
public interface AccountPlan {

    void handle(String value);
}
